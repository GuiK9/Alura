package br.com.alura.bytebank;

import br.com.bytebank.*;

public class TesteBiblioteca {
    public static void main(String[] args) {
        Conta c = new ContaCorrente(122, 321);
        c.deposita(122);

        System.out.println(c);
    }
    
}