package org.projeto1.servidor;

public class TratadorDeExecao implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("deu exeção na thread " + t.getName() + ", " + e.getMessage());
    }
}
