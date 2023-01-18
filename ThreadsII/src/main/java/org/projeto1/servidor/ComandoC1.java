package org.projeto1.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable{
    private final PrintStream saidaCliente;

    ComandoC1(PrintStream saidaCliente){
        this.saidaCliente = saidaCliente;
    }

    @Override
    public void run() {
        System.out.println("Executando Comando c1");

        try{
            Thread.sleep(20000);
        } catch (InterruptedException E){
            throw new RuntimeException(E);
        }

        saidaCliente.println("Comando c1 executado com sucesso!");
    }
}
