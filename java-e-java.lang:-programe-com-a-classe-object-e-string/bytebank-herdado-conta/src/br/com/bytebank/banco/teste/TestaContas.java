package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.especial.*;
import br.com.bytebank.banco.modelo.*;

public class TestaContas {
    public static void main(String[] args) throws SaldoInsuficienteException{
        ContaCorrente cc = new ContaCorrente(111, 111);
        cc.deposita(100.0);

        contaEspecial ce = new contaEspecial(122, 121);
        ce.deposita(1000);

        ContaPoupanca cp = new ContaPoupanca(222, 222);
        cp.deposita(200.0);

        cc.transfere(50, cp);
        cc.deposita(80);

        System.out.println("CP: " +  cp.getSaldo());
        cp.saca(100);

        
        System.out.println("CE: " + ce.getSaldo());
        System.out.println("CC: " + cc.getSaldo());
        System.out.println("CP: " + cp.getSaldo());
    }
}
