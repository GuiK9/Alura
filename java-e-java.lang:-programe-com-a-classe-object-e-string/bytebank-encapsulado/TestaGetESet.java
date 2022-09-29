public class TestaGetESet {
    public static void main(String[] args) {
        Conta conta = new Conta(1337, 24426);
        
        System.out.println(conta.getNumero());

        Cliente paulo = new Cliente();

        conta.setTitular(paulo);

        paulo.setNome("Paulo Silveira");

        System.out.println(conta.getTitular().getNome());

        conta.getTitular().setProfissao("Programador");

        System.out.println(conta.getTitular().getProfissao());

        System.out.println(conta.getTitular());
        
    }
}
