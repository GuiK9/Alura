package org.example2;

public class Banheiro {

    private boolean eSujo = true;
//  private final Lock lock = new ReentrantLock();

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        //lock.lock();
        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (eSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rápida");

            dormeUmPouco(5000);

            this.eSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
            //lock.unlock();
        }


    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");


        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (eSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            dormeUmPouco(10000);

            this.eSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void dormeUmPouco(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            this.notify();
        }
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + " eca, banheiro ta sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpa(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            if (!eSujo){
                System.out.println(nome + ", não é sujo");
                return;
            }

            System.out.println(nome + " limpando banheiro");
            eSujo = false;

            dormeUmPouco(13000);
            this.notify();

            System.out.println(nome + " saindo do banheiro");
        }

    }

}
