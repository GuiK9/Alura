package org.exmple3;

import java.util.List;

public class TarefaDaThread implements Runnable {
    private int numeroDaThread;
    private Lista lista;

    public TarefaDaThread(Lista lista, int numeroDaThread) {
        this.lista = lista;
        this.numeroDaThread = numeroDaThread;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lista.adicionaElementos(" " + j + " - thread " + numeroDaThread);
        }
    }
}
