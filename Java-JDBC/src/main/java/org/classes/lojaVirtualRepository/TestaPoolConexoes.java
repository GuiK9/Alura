package org.classes.lojaVirtualRepository;

import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connection = new ConnectionFactory();

        for (int i = 1; i < 20; i++) {
            connection.recuperarconexao();
            System.out.println(i);
        }
    }
}
