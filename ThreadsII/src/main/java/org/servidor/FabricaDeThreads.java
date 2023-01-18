package org.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {
    private static int numero;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread Servidor Tarefas " + numero);
        numero++;
        thread.setUncaughtExceptionHandler(new TratadorDeExecao());
        return thread;
    }
}
