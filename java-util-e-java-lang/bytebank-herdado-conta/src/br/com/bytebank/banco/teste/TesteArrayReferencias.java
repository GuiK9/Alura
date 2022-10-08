package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {
    public static void main(String[] args) {

        Object[] referencias = new Object[5];

        ContaCorrente cc1 = new ContaCorrente(22, 33);
        referencias[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(23, 12);
        referencias[1] = cc2;

        Cliente cliente = new Cliente();
        referencias[2] = cliente;

        referencias[3] = 1;


        System.out.println( ((ContaCorrente) referencias[0]).getValorImposto());

        ContaPoupanca ref = (ContaPoupanca) referencias[1];

        System.out.println(referencias[3]);
        System.out.println();

    }
}
