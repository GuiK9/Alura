public class Gerente extends FuncionarioAutenticavel {

    public double getbonificacao() {
        System.out.println("chamando metodo bonificacao Gerente");

        return super.getSalario();
    } 

}
