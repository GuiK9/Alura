package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ClienteDAO;
import br.com.loja.DAO.PedidoDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.*;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.awt.image.TileObserver;
import java.math.BigDecimal;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularDB();

        EntityManager em = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(em);
        Cliente cliente = clienteDAO.buscarPorId(1l);

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto produto = produtoDAO.buscarPorId(1L);

        em.getTransaction().begin();
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
        System.out.println("VALOR TOTAL: " + totalVendido);

    }

    private static void popularDB() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);
        Cliente cliente = new Cliente("Rodrigo", "233234");


        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        produtoDAO.cadastrar(celular);
        categoriaDAO.cadastrar(celulares);
        clienteDAO.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
