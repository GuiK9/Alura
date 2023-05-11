package br.com.loja.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoriaId id;
    public Categoria(){
    }
    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "xpto");
    }

    public String getNome(){
        return this.id.getNome();
    }

    public void setNome(String nome){
        this.id.setNome(nome);
    }
}

