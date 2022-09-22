// contrato Autenticável 
    // quem assina esse contrato, precisa implementar 
        // método set senha
        // Autentica 

public abstract interface Autenticavel{

    public abstract void setSenha(int senha);

    public abstract boolean autentica(int senha);


}
