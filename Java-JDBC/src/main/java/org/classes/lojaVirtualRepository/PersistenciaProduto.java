package org.classes.lojaVirtualRepository;

import java.sql.*;
import java.util.*;

public class PersistenciaProduto {
    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rst;
    private Produto produto;

    public PersistenciaProduto() {

    }

    private void connect() throws SQLException {
        this.connection = new ConnectionFactory().recuperarconexao();
    }

    private void setRst() throws SQLException {
        rst = this.pstm.getGeneratedKeys();
    }

    public Produto ProdutoAlterado() {
        return this.produto;
    }

    public void salvarProduto(Produto produto) throws SQLException {
        this.connect();
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?);";
        this.pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        this.pstm.setString(1, produto.getNome());
        this.pstm.setString(2, produto.getDescricao());
        this.pstm.execute();
        this.setRst();
        while (rst.next()) {
            produto.setId(rst.getInt(1));
            this.produto = produto;
        }
    }
}