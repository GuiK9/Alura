package org.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {
    public static void main(String[] args) throws Exception {
        System.out.println("----- iniciando o servidor -----");
        ServerSocket servidor = new ServerSocket(12345);

        while(true){
            Socket socket = servidor.accept();

            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            Thread threadCliente = new Thread(distribuirTarefas);
            threadCliente.start();
        }
    }
}