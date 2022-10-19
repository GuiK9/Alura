package br.com.bytebank.banco.modelo;

public class GuardadorDeReferencias {
    private Object[] referencias;
    private int PosicaoLivre;

    public GuardadorDeReferencias(int quantidade){
        this.referencias = new Conta[quantidade];
        this.PosicaoLivre = 0;
    }

    public void adiciona(Conta ref) {
        this.referencias[PosicaoLivre] = ref;
        PosicaoLivre++;
    }

    public int getQuantidadeDeElementos() {
        return this.PosicaoLivre;
    }

    public Object getElemento(int i) {
        return referencias[i];
    }
}
