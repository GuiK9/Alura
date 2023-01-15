package org.servidor;

import java.io.PrintStream;

public class ComandoC1 {
    private final PrintStream saidaCliente;

    ComandoC1(PrintStream saidaCliente){
        this.saidaCliente = saidaCliente;
        saidaCliente.println("comando executado");
    }
}
