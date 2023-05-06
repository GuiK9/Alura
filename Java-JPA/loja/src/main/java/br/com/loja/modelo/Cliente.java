package br.com.loja.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;
    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais();
        this.dadosPessoais.setNome(nome);
        this.dadosPessoais.setCpf(cpf);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() { return dadosPessoais.getNome(); }

    public void setNome(String nome) {
        dadosPessoais.setNome(nome);
    }

    public String getCpf() {
        return dadosPessoais.getCpf();
    }

    public void setCpf(String cpf) {
        dadosPessoais.setCpf(cpf);
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
}
