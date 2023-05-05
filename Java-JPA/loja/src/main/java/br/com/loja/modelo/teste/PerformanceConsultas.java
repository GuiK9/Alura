package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ClienteDAO;
import br.com.loja.DAO.PedidoDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.*;
import br.com.loja.modelo.vo.RelatorioDeVendasVo;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularDB();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        Pedido pedido = pedidoDAO.buscarPedidoComCliente(1L);
        em.close();
        System.out.println(pedido.getCliente().getNome());



    }
    private static void popularDB() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal(5000), videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro retri", new BigDecimal(7000), informatica);

        Cliente cliente = new Cliente("Rodrigo", "233234");

        Pedido pedido = new Pedido(cliente);
        Pedido pedido2 = new Pedido(cliente);


        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);


        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        categoriaDAO.cadastrar(videogames);
        categoriaDAO.cadastrar(informatica);

        produtoDAO.cadastrar(celular);
        produtoDAO.cadastrar(videogame);
        produtoDAO.cadastrar(macbook);

        clienteDAO.cadastrar(cliente);

        pedido.adicionarItem(new ItemPedido(10, pedido, celular));
        pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

        pedido2.adicionarItem(new ItemPedido(2, pedido, macbook));

        pedidoDAO.cadastrar(pedido);
        pedidoDAO.cadastrar(pedido2);

        em.getTransaction().commit();
        em.close();

    }
}
