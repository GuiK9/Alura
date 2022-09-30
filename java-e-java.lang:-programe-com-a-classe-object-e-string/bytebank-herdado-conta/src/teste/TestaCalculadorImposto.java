package teste;

public class TestaCalculadorImposto {
    public static void main(String[] args) {
        modelo.CalculadorImposto ci = new modelo.CalculadorImposto();

        modelo.ContaCorrente contac1 = new modelo.ContaCorrente(222, 12123);
        contac1.deposita(1000);
        ci.registra(contac1);


        modelo.ContaCorrente contac2 = new modelo.ContaCorrente(222, 12123);
        contac2.deposita(1000);
        ci.registra(contac2);


        modelo.ContaCorrente contac3 = new modelo.ContaCorrente(222, 12123);
        contac3.deposita(1000);
        ci.registra(contac3);

        modelo.SeguroDeVida seguro1 = new modelo.SeguroDeVida();
        ci.registra(seguro1);

        modelo.SeguroDeVida seguro2 = new modelo.SeguroDeVida();
        ci.registra(seguro2);

        modelo.SeguroDeVida seguro3 = new modelo.SeguroDeVida();
        ci.registra(seguro3);


        System.out.println(ci.getTotalImposto());

    }
}
