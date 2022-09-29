package modelo;

public class ContaPoupanca extends Conta implements Tributavel{


    public ContaPoupanca(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.1;
    } 
}
