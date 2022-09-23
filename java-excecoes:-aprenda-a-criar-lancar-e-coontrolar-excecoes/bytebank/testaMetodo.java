public class testaMetodo {
    public static void main(String[] args) {
        Conta contaDoPaulo = new Conta();
        contaDoPaulo.saldo = 100;
        contaDoPaulo.deposita(20);
        System.out.println(contaDoPaulo.saldo);

        boolean conseguiuRetirar = contaDoPaulo.saca(20);
        System.out.println(conseguiuRetirar);
        System.out.println(contaDoPaulo.saldo);

        Conta contaDaMarcela = new Conta();
        contaDaMarcela.deposita(1000);


        if(contaDaMarcela.transfere(3000, contaDoPaulo)){
            System.out.println("Transferência feita com sucesso");
        } else {
            System.out.println("Faltou dinheiro");
        }
        System.out.println(contaDaMarcela.saldo + "Saldo da conta da marcela");
        System.out.println(contaDoPaulo.saldo + "Saldo da conta do paulo");

    
        System.out.println(contaDoPaulo.titular);
    }
}
