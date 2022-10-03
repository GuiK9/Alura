package br.com.bytebank.banco.modelo;

public class ContaCorrente extends Conta implements Tributavel{
    
    public ContaCorrente(int agencia, int numero){
        super(agencia, numero);
    }
  

    @Override
    public void saca(double valor) throws SaldoInsuficienteException {
        double valorASacar = valor + 0.2;
        super.saca(valorASacar);

        
    }



    @Override
    public void deposita(double valor) {

        if(valor < 0 ){
            throw new IllegalArgumentException(Double.toString(valor) + " é menor que zero");
        }
        super.saldo += valor;
    }



    @Override
    public double getValorImposto() {
        double saldo = getSaldo();
        return saldo * 0.02;
    }
}
