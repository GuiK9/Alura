package br.com.bytebank.banco.teste;


public class TestaCalculadorImposto {
    public static void main(String[] args) {
        br.com.bytebank.banco.modelo.CalculadorImposto ci = new br.com.bytebank.banco.modelo.CalculadorImposto();

        br.com.bytebank.banco.modelo.ContaCorrente contac1 = new br.com.bytebank.banco.modelo.ContaCorrente(222, 12123);
        contac1.deposita(1000);
        ci.registra(contac1);


        br.com.bytebank.banco.modelo.ContaCorrente contac2 = new br.com.bytebank.banco.modelo.ContaCorrente(222, 12123);
        contac2.deposita(1000);
        ci.registra(contac2);


        br.com.bytebank.banco.modelo.ContaCorrente contac3 = new br.com.bytebank.banco.modelo.ContaCorrente(222, 12123);
        contac3.deposita(1000);
        ci.registra(contac3);

        br.com.bytebank.banco.modelo.SeguroDeVida seguro1 = new br.com.bytebank.banco.modelo.SeguroDeVida();
        ci.registra(seguro1);

        br.com.bytebank.banco.modelo.SeguroDeVida seguro2 = new br.com.bytebank.banco.modelo.SeguroDeVida();
        ci.registra(seguro2);

        br.com.bytebank.banco.modelo.SeguroDeVida seguro3 = new br.com.bytebank.banco.modelo.SeguroDeVida();
        ci.registra(seguro3);


        System.out.println(ci.getTotalImposto());

    }
}
