package org.projeto1.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {
    private final Socket socket;
    private final ServidorTarefas servidor;
    private final ExecutorService threadPool;
    private final BlockingQueue<String> filaComandos;

    public DistribuirTarefas(ExecutorService threadPool, BlockingQueue<String> filaComandos, Socket socket, ServidorTarefas servidor) {
        this.socket = socket;
        this.threadPool = threadPool;
        this.servidor = servidor;
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas para: " + socket.getPort());
        try {
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while (entradaCliente.hasNextLine()) {
                String comando = entradaCliente.nextLine();
                System.out.println("comando recebido " + comando);
                switch (comando) {
                    case "c1" -> {
                        saidaCliente.println("confirmação comando c1");
                        ComandoC1 c1 = new ComandoC1(saidaCliente);
                        this.threadPool.execute(c1);
                    }
                    case "c2" -> {
                        saidaCliente.println("confirmação cliente c2");
                        ComandoC2ChamaWS c2WS = new ComandoC2ChamaWS(saidaCliente);
                        ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);
                        Future<String> futureWS = this.threadPool.submit(c2WS);
                        Future<String> futureBanco = this.threadPool.submit(c2Banco);
                        this.threadPool.submit(new TrabalhaResultadosComandoC1EC2(futureWS, futureBanco, saidaCliente));
                    } case "c3" -> {
                        System.out.println("quantidade de comandos " + filaComandos.size());
                        System.out.println(filaComandos);
                        this.filaComandos.put(comando);//blocks
                        System.out.println(filaComandos);
                        saidaCliente.println("Comando c3 adicionado na fila");
                    }
                    case "fim" -> {
                        saidaCliente.println("Desligando o servidor ");
                        servidor.parar();
                    }
                    default -> saidaCliente.println("comando " + comando + " não encontrado");
                }
            }
            saidaCliente.close();
            entradaCliente.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
