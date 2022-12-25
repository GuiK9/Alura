package org.example.t1;



public class ImprimaString {
    public static void main(String[] args) {
        System.out.println("essa é a " + Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("essa é a anônima Runnable " + Thread.currentThread().getName());
            }
        }).start();

        Thread tarefa = new Thread(()-> {
            System.out.println("essa é a " + Thread.currentThread().getName());
        });
        tarefa.start();
    }
}