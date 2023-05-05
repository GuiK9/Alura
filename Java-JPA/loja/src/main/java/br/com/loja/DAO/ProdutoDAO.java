package br.com.loja.DAO;

import br.com.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        return em.createNamedQuery("Produto.produtoPorCategoria", Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "SELECT p FROM Produto p WHERE 1=1";
        if (nome != null && !nome.trim().isEmpty()) {
            jpql += " AND p.nome = :nome";
        }
        if (preco != null) {
            jpql += " AND p.preco = :preco";
        }
        if (dataCadastro != null) {
            jpql += " AND p.dataCadastro = :dataCadastro";
        }
        TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
        if (nome != null && !nome.trim().isEmpty()) {
            query.setParameter("nome", nome);
        }
        if (preco != null) {
            query.setParameter("preco", preco);
        }
        if (dataCadastro != null) {
            query.setParameter("dataCadastro", dataCadastro);
        }

        return query.getResultList();
    }
}
