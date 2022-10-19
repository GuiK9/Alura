package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeReferencias;

public class TesteguardadorDeReferencia {
    public static void main(String[] args) {
        GuardadorDeReferencias guardador = new GuardadorDeReferencias(25);

        Conta cc = new ContaCorrente(11, 34);
        Conta cc2 = new ContaCorrente(11, 31);

        guardador.adiciona(cc);
        guardador.adiciona(cc2);

        int tamanho = guardador.getQuantidadeDeElementos();
        System.out.println(tamanho);

        Conta ref = (Conta) guardador.getElemento(1);
        System.out.println(ref);

    }
}
