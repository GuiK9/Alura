public class TesteCondicional2 {
    public static void main(String[] args) {
        System.out.println("testando condicionais2");

        int idade = 20;
        int quantidadePessoas = 3;
        boolean acompanhado = quantidadePessoas > 1; 


        if (idade >= 18 && acompanhado) {
            System.out.println("Seja bem vindo");
        } else {
            System.out.println("infelizmente você não pode entrar");
        }
    }
}
