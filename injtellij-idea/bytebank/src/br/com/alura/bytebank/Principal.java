package br.com.alura.bytebank;

import br.com.alura.bytebank.model.Funcionario;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao bytebank");
        Funcionario jose = new Funcionario("jose", 1, LocalDate.of(1990, 12, 10));
        Funcionario maria = new Funcionario("maria", 2, LocalDate.of(1995, 5, 22));
        System.out.println(jose);
        System.out.println(maria);
    }
}
