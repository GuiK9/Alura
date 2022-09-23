public class TesteReferencias {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();

        primeiraConta.saldo = 300;


        System.out.println("Saldo da primeira " + primeiraConta.saldo);

        Conta segundaConta = primeiraConta;

        segundaConta.saldo = 150;

        System.out.println("Saldo da segunda conta " + segundaConta.saldo);
        System.out.println("Saldo da primeira conta " + primeiraConta.saldo);

        if(primeiraConta == segundaConta){
            System.out.println("São a mesma conta");
        }

    }
}
