package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("CÔMODA", "CÔMODA DE MADEIRA");
        try(Connection connection = new ConnectionFactory().recuperarconexao()){
            String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?);";
            try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, comoda.getNome());
                pstm.setString(2, comoda.getDescricao());
                pstm.execute();
                try(ResultSet rst = pstm.getGeneratedKeys()){
                    while(rst.next()){
                        comoda.setId(rst.getInt(1));
                    }
                }
            }
        }
        System.out.println(comoda);
    }
}
