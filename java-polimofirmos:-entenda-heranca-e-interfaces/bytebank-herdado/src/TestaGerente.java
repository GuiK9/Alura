public class TestaGerente {
    public static void main(String[] args) {
        Gerente g1 = new Gerente();

        g1.setNome("Guilherme");
        g1.setSalario(5000.0);
        g1.setCpf("22422322350");


        System.out.println(g1.getNome());
        System.out.println(g1.getSalario());
        System.out.println(g1.getCpf());

        boolean autenticou = g1.autentica(1222);

        System.out.println(autenticou);


    }
}
