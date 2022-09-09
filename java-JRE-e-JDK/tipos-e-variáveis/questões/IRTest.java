public class IRTest {
    public static void main(String[] args) {

        double salario = 900;
        double aliquota;
        int deducao;

        if (salario > 1900 && salario < 2800) {
            aliquota = 7.5;
            deducao = 142;
        } else if (salario > 2800.01 && salario < 3751) {
            aliquota = 15;
            deducao = 350;
        } else if (salario > 37501.01 && salario < 4664) {
            aliquota = 22.5;
            deducao = 636;
        } else {
            aliquota = 1;
            deducao = 1;
        }

        if (aliquota != 1) {
            double impostoDevido = ((salario * 100) / aliquota) - deducao;
            System.out.println("Imposto devido é " + impostoDevido + "$");

        } else {
            if (salario < 1900) {
                System.out.println("pobre");
            } else {
                System.out.println("tu ganha muito ein filhote!");
            }

        }

    }
}
