package br.com.loja.modelo;

import jakarta.persistence.Entity;

@Entity
public class Livro  extends Produto{
    private String autor;
    Integer numeroDePagina;

    public Livro(String autor, Integer numeroDePagina) {
        this.autor = autor;
        this.numeroDePagina = numeroDePagina;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroDePagina() {
        return numeroDePagina;
    }

    public void setNumeroDePagina(Integer numeroDePagina) {
        this.numeroDePagina = numeroDePagina;
    }
}
