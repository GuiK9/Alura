package org.classes.lojaVirtualRepository;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int anInt) {
        id = anInt;
    }
    @Override
    public String toString() {
        return "Produto { " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                " }";
    }
}
