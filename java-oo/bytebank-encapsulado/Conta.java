public class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente  titular;

    public Conta() {
        System.out.println("estou criando uma conta");
    }

    public void deposita(double valor) {
        saldo += valor;
    }

    public boolean saca(double valor){
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino){
        
        boolean sacou = this.saca(valor);
        if(sacou) {
            destino.saldo += valor;
            return true;
        } else {
            return false;
        }
        
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0){
            System.out.println("não pode valor <= a 0");
            return;
        }

        this.numero = numero;
    }

    public int getAgencia() {
        
        return agencia;
    }

    public void setAgencia(int agencia) {
        if(numero <= 0){
            System.out.println("não pode valor igual a 0");
            return;
        }

        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    

}
