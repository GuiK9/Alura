package org.DeadLock;

public class TarefaAcessarBancoProcedimento implements Runnable {
    private GerenciadorDeTransacao tx;
    private PoolDeConexao pool;

    public TarefaAcessarBancoProcedimento(GerenciadorDeTransacao tx, PoolDeConexao pool) {
        this.tx = tx;
        this.pool = pool;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();
            synchronized (tx) {
                System.out.println("começando a tx");
                tx.begin();
            }
        }
    }
}
