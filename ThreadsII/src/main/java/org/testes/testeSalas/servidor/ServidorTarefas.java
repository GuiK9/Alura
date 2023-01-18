package org.testes.testeSalas.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {
    public static void main(String[] args) throws Exception {
        System.out.println("----- iniciando o servidor -----");
        ServerSocket servidor = new ServerSocket(12345);

        ExecutorService threadPool = Executors.newCachedThreadPool();

        while(true){
            Socket socket = servidor.accept();
            DistribuidorDeChats distribuidorDeChats = new DistribuidorDeChats(socket);
            threadPool.execute(distribuidorDeChats);
        }
    }
}