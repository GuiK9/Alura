package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {
    private String nomeDoArquivo;
    private String nomeBuscado;

    public TarefaBuscaTextual(String nomeDoArquivo, String nomeBuscado) {
        this.nomeDoArquivo = nomeDoArquivo;
        this.nomeBuscado = nomeBuscado;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(nomeDoArquivo));

           int linhaAtual = 0;

            while(scanner.hasNextLine()){
                linhaAtual++;
                String linha = scanner.nextLine();
                if (linha.toLowerCase().contains(nomeBuscado)){

                    System.out.println(nomeDoArquivo + " - " + linhaAtual + " - " + linha);
                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
