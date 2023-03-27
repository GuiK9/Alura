package org.dao;

import org.classes.lojaVirtualRepository.ConnectionFactory;
import org.classes.lojaVirtualRepository.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rst;
    private Produto produto;

    public ProdutoDAO() throws SQLException {
        this.connection = new ConnectionFactory().recuperarconexao();
    }
    public void setPstm(String sql) throws SQLException {
        this.pstm = this.connection.prepareStatement(sql);
    }

    private void setRst() throws SQLException {
        rst = this.pstm.getGeneratedKeys();
    }

    public Produto ProdutoAlterado() {
        return this.produto;
    }

    public void salvar(Produto produto) throws SQLException {
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

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT OD, NOME, DESCRICAO FROM PRODUTO";
        this.setPstm(sql);
        pstm.execute();
        this.setRst();
        return produtos;
    }
}