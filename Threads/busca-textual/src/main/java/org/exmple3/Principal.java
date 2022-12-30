package org.exmple3;

import java.util.List;
import java.util.Vector;

public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaDaThread(lista, i)).start();
        }

        new Thread(new ImprimeLista(lista), "imprimeLista").start();
    }
}
