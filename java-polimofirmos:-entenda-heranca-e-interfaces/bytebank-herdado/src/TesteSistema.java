public class TesteSistema {
    public static void main(String[] args) {
        Gerente g = new Gerente();
        g.setSenha(222);

        Administrador ad = new Administrador();
        ad.setSenha(333);

        SistemaInterno si = new SistemaInterno();
        si.autentica(g);
        si.autentica(ad);
    }
}
