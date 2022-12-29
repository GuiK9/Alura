package org.example2;

public class Limpeza implements Runnable {
    private Banheiro banheiro;
    public Limpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }
    @Override
    public void run() {
        while (true){
            banheiro.limpa();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
