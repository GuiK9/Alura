package org.testeSalas.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão estabelecida");

        Thread threadEnviaComando = new Thread(() -> {
            System.out.println("pode enviar comandos");
            Scanner teclado = new Scanner(System.in);
            PrintStream saida;
            try {
                saida = new PrintStream(socket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (teclado.hasNextLine()) {
                String linha = teclado.nextLine();
                if (linha.trim().equals("")) {
                    break;
                }
                saida.println(linha);
            }
            saida.close();
            teclado.close();

        });

        Thread threadRecebeResposta = new Thread(() -> {
            System.out.println("recebendo dados do servidor!!");
            Scanner respostaServidor;
            try {
                respostaServidor = new Scanner(socket.getInputStream());
                while (respostaServidor.hasNextLine()) {
                    String linha = respostaServidor.nextLine();
                    System.out.println(linha);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            respostaServidor.close();
        });
        threadEnviaComando.start();
        threadRecebeResposta.start();
        threadEnviaComando.join();
        System.out.println("fechando socket do cliente");
        socket.close();
    }
}
