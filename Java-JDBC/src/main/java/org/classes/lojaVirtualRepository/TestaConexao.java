package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarconexao();
        System.out.println("conectou!!");
        con.close();
        System.out.println("fechou a conexão");
    }

}
