package org.testes.testeSalas.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuidorDeChats implements Runnable{
    private final Socket socket;
    public DistribuidorDeChats(Socket socket) {
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
                    case "c1" -> {
                        saidaCliente.println("confirmação entrada para sala: c1");
                        new Thread(new sala(socket)).start();
                        saidaCliente.close();
                        entradaCliente.close();
                    }
                    case "c2" -> saidaCliente.println("confirmação cliente c2");
                    default -> saidaCliente.println("comando não encontrado");
                }
                System.out.println(comando);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
