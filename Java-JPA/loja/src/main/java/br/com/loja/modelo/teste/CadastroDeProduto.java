package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto p = produtoDAO.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> produtos = produtoDAO.buscarPorNomeDaCategoria("CELULARES");
        produtos.forEach(produto -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("xiaomi");
        System.out.println(precoDoProduto + " ===========");
    }

    private static void cadastrarProduto() {
        Produto celular;
        Categoria celulares = new Categoria("CELULARES");
        celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);


        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        em.getTransaction().begin();

        em.persist(celulares);
        celulares.setNome("XPTO");

        em.flush();
        em.clear();

        celulares.setNome("123456");
        categoriaDAO.atualizar(celulares);

        em.clear();
        categoriaDAO.remove(celulares);
        em.flush();
    }


}
