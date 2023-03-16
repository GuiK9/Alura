package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperarconexao();

        PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        String nome = "MOUSE";
        String descricao = "MOUSE SEM FIO";

        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();


        ResultSet rst = stm.getGeneratedKeys();
        while(rst.next()) {
            int id = rst.getInt(1);
            System.out.println("o id criado foi " + id);
        }
    }
}
