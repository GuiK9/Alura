package org.example2;

public class TarefaNumero1 implements Runnable {
    private Banheiro banheiro;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero1();
    }
}
