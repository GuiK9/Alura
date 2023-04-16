package br.com.loja.modelo.teste;

import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.*;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular;
        celular = new Produto();
        celular.setNome("xiaomi");
        celular.setDescricao("Muito Legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = new JPAUtil().getEntityMananger();
        ProdutoDAO dao = new ProdutoDAO(em);
        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

    }


}
