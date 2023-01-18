package org.testes.testeSalas.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class sala implements Runnable {

    private final Socket socket;

    public sala(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while (entradaCliente.hasNextLine()){
                saidaCliente.println(entradaCliente);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
