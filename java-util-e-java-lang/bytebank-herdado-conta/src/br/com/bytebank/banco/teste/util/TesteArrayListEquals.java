package br.com.bytebank.banco.teste.util;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

import java.util.ArrayList;

public class TesteArrayListEquals {

    public static void main(String[] args) {
        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(11, 34);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(11, 31);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(11, 31);

        //boolean existe = true; = lista.contains(cc3);

        if(cc3.ehIgual(lista)){
            System.out.println("Já existe!!!");
        }

        //System.out.println("já existe? " + existe);



//        for (Object oRef : lista) {
//            System.out.println(oRef);
//        }


    }

}
