package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*; 

public class TesteSaca {
     public static void main(String[] args) {
        Conta conta = new ContaCorrente(123, 111);
        conta.deposita(200);
        try {
            conta.saca(290);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Ex: " + e.getMessage());
        }

        System.out.println(conta.getSaldo());
    } 
}
