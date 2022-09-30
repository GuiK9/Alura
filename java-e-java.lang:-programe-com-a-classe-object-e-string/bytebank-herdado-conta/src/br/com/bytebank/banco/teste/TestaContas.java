package br.com.bytebank.banco.teste;

public class TestaContas {
    public static void main(String[] args) throws br.com.bytebank.banco.modelo.SaldoInsuficienteException{
        br.com.bytebank.banco.modelo.ContaCorrente cc = new br.com.bytebank.banco.modelo.ContaCorrente(111, 111);
        cc.deposita(100.0);

        br.com.bytebank.banco.modelo.ContaPoupanca cp = new br.com.bytebank.banco.modelo.ContaPoupanca(222, 222);
        cp.deposita(200.0);

        cc.transfere(50, cp);
        cc.deposita(-80);

        System.out.println("CP: " +  cp.getSaldo());
        cp.saca(100);

        

        System.out.println("CC: " + cc.getSaldo());
        System.out.println("CP: " + cp.getSaldo());
    }
}
