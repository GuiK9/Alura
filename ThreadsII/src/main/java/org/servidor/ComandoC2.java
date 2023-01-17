package org.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable{
    private final PrintStream saidaCliente;

    ComandoC2(PrintStream saidaCliente){
        this.saidaCliente = saidaCliente;
    }

    @Override
    public void run() {
        System.out.println("Executando Comando c2");

        try{
            Thread.sleep(20000);
        } catch (InterruptedException E){
            throw new RuntimeException(E);
        }

        saidaCliente.println("Comando c2 executado com sucesso!");
    }
}
