package org.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable{
    private final Socket socket;
    public DistribuirTarefas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas para: " + socket.getPort());
        try {
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while(entradaCliente.hasNextLine()){
                String comando = entradaCliente.nextLine();
                System.out.println("comando recebido " + comando);
                switch (comando) {
                    case "c1" -> saidaCliente.println("confirmação comando c1");
                    case "c2" -> saidaCliente.println("confirmação cliente c2");
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
