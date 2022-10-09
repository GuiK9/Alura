package br.com.bytebank.banco.teste.util;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

import java.util.ArrayList;

public class TesteArrayList {

    public static void main(String[] args) {
        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(11, 34);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(11, 31);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(12, 95);
        lista.add(cc2);

        Conta cc4 = new ContaCorrente(12, 90);
        lista.add(cc2);

        System.out.println("Tamanho: " + lista.size());
        Conta ref = lista.get(0);
        System.out.println(lista.get(0));

        lista.remove(0);

        System.out.println("Tamanho: " + lista.size());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        System.out.println("==============");
        for (Object oRef : lista) {
            System.out.println(oRef);
        }


    }

}
