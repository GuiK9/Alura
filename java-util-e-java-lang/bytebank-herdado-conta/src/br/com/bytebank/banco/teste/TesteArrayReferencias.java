package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayReferencias {
    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

        ContaCorrente cc1 = new ContaCorrente(22, 33);
        contas[0] = cc1;

        ContaCorrente cc2 = new ContaCorrente(23, 12);
        contas[1] = cc2;

        System.out.println(contas[1].getValorImposto());

        ContaCorrente ref = contas[1];

        System.out.println(ref);

    }
}
