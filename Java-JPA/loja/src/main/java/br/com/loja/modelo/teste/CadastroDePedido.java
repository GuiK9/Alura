package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        cadastrarProduto();

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);


        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        em.getTransaction().begin();
        produtoDAO.cadastrar(celular);
        categoriaDAO.cadastrar(celulares);
        System.out.println(produtoDAO.buscarTodos());
        em.close();
    }
}
