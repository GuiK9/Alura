package org.classes.lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("cômoda", "Cômoda de madeira");
        try(Connection connection = new ConnectionFactory().recuperarconexao()){
            String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?);";
            try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        }
    }
}
