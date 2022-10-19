package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapper {
    public static void main(String[] args) {
        int[] idades = new int[5];
        String[] nomes = new String[5];

        int idade = 29;// Integer

        Integer idaderef = Integer.valueOf(29); //Devolve um objeto desse primitivo, autoboxing
        int valor = idaderef.intValue(); //unboxing
        System.out.println(idaderef.doubleValue());


        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);


        System.out.println(valor);
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(29);

        String s = args[0];//"10"
        //Integer numero = Integer.valueOf(s);
        int numero = Integer.parseInt(s);
        System.out.println(numero);

        System.out.println(Integer.valueOf(29));

    }
}
