public class SistemaInterno {

    private int senha = 222;

    public void autentica(Autenticavel a){
        boolean  autenticou = a.autentica(this.senha);
        if(autenticou){
            System.out.println("Pode entrar no sistema");
        } else {
            System.out.println("não pode entrar no sistema");
        }
    }
}
