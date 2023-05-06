package br.com.loja.modelo;


import jakarta.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
    String nome;
    String cpf;

    public DadosPessoais() {
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
