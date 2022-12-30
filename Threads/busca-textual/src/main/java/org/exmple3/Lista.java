package org.exmple3;

public class Lista {
    private final String[] elementos = new String[1000];
    private int indice = 0;
    private int numeroDoThread;

    public synchronized void adicionaElementos(String elemento) {
       try {
           Thread.sleep(10);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
        this.elementos[indice] = elemento;
        this.indice++;

        if (indice == this.elementos.length) {
            System.out.println("Lista está cheia notificação");
            this.notify();
        }
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }


    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
}
