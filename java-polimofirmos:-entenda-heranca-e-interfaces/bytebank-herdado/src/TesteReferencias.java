public class TesteReferencias {
    public static void main(String[] args) {

        Gerente g1 = new Gerente(); // variável do tipo mais genérico
        g1.setNome("Thiago");
        g1.setSalario(5000.0);

        EditorDeVideo ev = new EditorDeVideo();
        ev.setSalario(2500.0);

        Designer d = new Designer();
        d.setSalario(2000.0);


        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(g1);
        controle.registra(ev);
        controle.registra(d);

        System.out.println(controle.getSoma());

    }
}
