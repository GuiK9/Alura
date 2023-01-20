package org.projeto1.servidor;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumir implements Runnable{
    private final BlockingQueue<String> filaComandos;

    public TarefaConsumir(BlockingQueue<String> filaComandos) {
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {
        try {
            String comando = filaComandos.take();

            System.out.println("Consumindo comando " + comando);
            Thread.sleep(10000);
            System.out.println("consumido!!!!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
