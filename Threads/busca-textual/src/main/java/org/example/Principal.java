package org.example;

public class Principal {
    public static void main(String[] args) {
        String nome = "da";

        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("src/assinaturas1.txt", nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("src/assinaturas2.txt", nome));
        Thread threadAssinaturas3 = new Thread(new TarefaBuscaTextual("src/autores.txt", nome));
        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAssinaturas3.start();
    }
}