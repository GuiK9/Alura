package org.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {
    private final Socket socket;
    private final ServidorTarefas servidor;
    private final ExecutorService threadPool;

    public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
        this.socket = socket;
        this.threadPool = threadPool;
        this.servidor = servidor;
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
                        ComandoC2 c2 = new ComandoC2(saidaCliente);
                        this.threadPool.execute(c2);
                    }
                    case "fim" -> {
                        saidaCliente.println("Desligando o servidor ");
                        servidor.parar();
                    }
                    default -> saidaCliente.println("comando não encontrado");
                }
                System.out.println(comando);
            }
            saidaCliente.close();
            entradaCliente.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
