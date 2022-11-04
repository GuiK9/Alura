package br.com.alura.tdd.aula;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);
        System.out.println(soma);

        int soma1 = calc.somar(0, 0);
        System.out.println(soma1);

        int soma2 = calc.somar(3, -1);
        System.out.println(soma2);

        int soma3 = calc.somar(3, 0);
        System.out.println(soma3);

    }
}
