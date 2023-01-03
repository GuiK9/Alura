package org.DeadLock;

public class PrincipalBanco {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessarBanco(tx, pool)).start();
        new Thread(new TarefaAcessarBancoProcedimento(tx, pool)).start();
    }
}