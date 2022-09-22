public class Gerente extends Funcionario implements Autenticavel {

    private Autenticador autenticador;

    public Gerente() {
        autenticador = new Autenticador();
    }

    @Override
    public void setSenha(int senha) {
        autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return autenticador.autentica(senha);
    }

    public double getbonificacao() {
        System.out.println("chamando metodo bonificacao Gerente");

        return super.getSalario();
    }

}
