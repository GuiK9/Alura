package org.testes.teste1;

import org.projeto1.servidor.TratadorDeExecao;

import java.util.Properties;

public class Principal {

    public static void main(String[] args) {
        Properties properties = new Properties();
        Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo1.txt"));
        thread.setUncaughtExceptionHandler(new TratadorDeExecao());
        thread.start();
    }
}

