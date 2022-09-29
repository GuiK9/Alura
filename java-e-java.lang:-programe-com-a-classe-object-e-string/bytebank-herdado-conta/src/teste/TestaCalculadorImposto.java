package teste;

import modelo.ContaCorrente;
import modelo.SeguroDeVida;
import modelo.CalculadorImposto;

public class TestaCalculadorImposto {
    public static void main(String[] args) {
        CalculadorImposto ci = new CalculadorImposto();

        ContaCorrente contac1 = new ContaCorrente(222, 12123);
        contac1.deposita(1000);
        ci.registra(contac1);


        ContaCorrente contac2 = new ContaCorrente(222, 12123);
        contac2.deposita(1000);
        ci.registra(contac2);


        ContaCorrente contac3 = new ContaCorrente(222, 12123);
        contac3.deposita(1000);
        ci.registra(contac3);

        SeguroDeVida seguro1 = new SeguroDeVida();
        ci.registra(seguro1);

        SeguroDeVida seguro2 = new SeguroDeVida();
        ci.registra(seguro2);

        SeguroDeVida seguro3 = new SeguroDeVida();
        ci.registra(seguro3);


        System.out.println(ci.getTotalImposto());

    

    }
}
