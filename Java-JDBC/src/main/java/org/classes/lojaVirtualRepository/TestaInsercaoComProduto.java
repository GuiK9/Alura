package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("CÔMODA", "CÔMODA DE MADEIRA");
        PersistenciaProduto persistenciaProduto = new PersistenciaProduto();
        persistenciaProduto.salvarProduto(comoda);
        System.out.println(persistenciaProduto.ProdutoAlterado());
    }
}

