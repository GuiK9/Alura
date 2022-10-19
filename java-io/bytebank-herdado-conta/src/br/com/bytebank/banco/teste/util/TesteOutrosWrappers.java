package br.com.bytebank.banco.teste.util;

import com.sun.jdi.DoubleValue;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {
    public static void main(String[] args) {

        Integer idadeRef = Integer.valueOf(29); //autoboxing.
        System.out.println(idadeRef.intValue()); //unboxing.

        Double dRef = Double.valueOf(3.2); //autoboxing
        System.out.println(dRef.doubleValue()); //unboxing

        Object bRef = Boolean.TRUE; //autobixing
        System.out.println(((Boolean) bRef).booleanValue()); //unboxing

        Number refNumero = Double.valueOf(29.9);
        System.out.println(refNumero.byteValue());

        List<Number> lista = new ArrayList<>();
        lista.add(10);
        lista.add(32.6);
        lista.add(26.6f);

    }
}
