package org.classes.lojaVirtualRepository;

import org.dao.ProdutoDAO;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("CÔMDA", "CÔMODA DE MADEIRA");
        ProdutoDAO ProdutoDAO = new ProdutoDAO();
        ProdutoDAO.salvar(comoda);
        System.out.println(ProdutoDAO.ProdutoAlterado());
    }
}

