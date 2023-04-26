package br.com.loja.DAO;

import br.com.loja.modelo.Pedido;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }
    public Pedido buscarPorId(Long id){
        return em.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos(){
        String jpql = "SELECT p FROM pedido p";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }

    public List<Pedido> buscarPorNome(String nome){
        String jpql = "SELECT p FROM pedido p WHERE p.nome = ?1";
        return em.createQuery(jpql, Pedido.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Pedido> buscarPorNomeDaCategoria(String nome){
        String jpql = "SELECT p FROM pedido p WHERE p.categoria.nome = ?1";
        return em.createQuery(jpql, Pedido.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDopedidoComNome(String nome){
        String jpql = "SELECT p FROM pedido p WHERE p.nome = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
}
