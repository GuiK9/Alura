package br.com.loja.DAO;

import br.com.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);

    }
}
