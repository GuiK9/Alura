package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.*;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular;
        Categoria celulares = new Categoria("CELULARES");
        celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = new JPAUtil().getEntityMananger();
        ProdutoDAO produtoDao = new ProdutoDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
