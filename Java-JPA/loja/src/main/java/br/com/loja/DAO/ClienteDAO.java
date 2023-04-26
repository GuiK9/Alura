package br.com.loja.DAO;

import br.com.loja.modelo.Cliente;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }
    public Cliente buscarPorId(Long id){
        return em.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos(){
        String jpql = "SELECT p FROM cliente p";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> buscarPorNome(String nome){
        String jpql = "SELECT p FROM cliente p WHERE p.nome = ?1";
        return em.createQuery(jpql, Cliente.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Cliente> buscarPorNomeDaCategoria(String nome){
        String jpql = "SELECT p FROM cliente p WHERE p.categoria.nome = ?1";
        return em.createQuery(jpql, Cliente.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoclienteComNome(String nome){
        String jpql = "SELECT p FROM cliente p WHERE p.nome = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }
}
