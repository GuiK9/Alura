package org.example2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {
    private Lock lock = new ReentrantLock();
    public void fazNumero1(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        lock.lock();

        System.out.println(nome + " entrando no banheiro");
        System.out.println(nome + " fazendo coisa rápida");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nome + " dando descarga");
        System.out.println(nome + " lavando a mão");
        System.out.println(nome + " saindo do banheiro");

        lock.unlock();

    }
    public void fazNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");


        synchronized (this){
            System.out.println(nome + " entrando no banheiro");
            System.out.println(nome + " fazendo coisa demorada");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
        }
    }
}
