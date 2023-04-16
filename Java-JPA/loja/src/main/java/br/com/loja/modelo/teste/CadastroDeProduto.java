package br.com.loja.modelo.teste;

import br.com.loja.modelo.Produto;
import jakarta.persistence.*;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular;
        celular = new Produto();
        celular.setNome("xiaomi");
        celular.setDescricao("Muito Legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();

    }
}
