public class Cliente implements Autenticavel{

    
    private Autenticador autenticador;

    public Cliente(){
        Autenticador autenticador = new Autenticador();
    }

    @Override
    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return autenticador.autentica(senha);
    
    }

    
}