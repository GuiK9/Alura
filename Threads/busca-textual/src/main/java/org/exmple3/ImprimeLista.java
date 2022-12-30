package org.exmple3;

public class ImprimeLista implements Runnable {
    private final Lista lista;

    public ImprimeLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {

        synchronized (lista){

            if(!lista.estaCheia()){
                try {
                    System.out.println("indo esperar aguardando notificação");
                    lista.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.println(i + " - " + lista.pegaElemento(i));
            }
        }

    }
}
