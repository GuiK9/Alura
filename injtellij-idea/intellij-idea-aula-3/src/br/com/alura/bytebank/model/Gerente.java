package br.com.alura.bytebank.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {

    double bonus;
    String usuario;
    String senha;


    public Gerente(String nome, int matricula, LocalDate dataNascimento) {
        super(nome, matricula, dataNascimento);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
