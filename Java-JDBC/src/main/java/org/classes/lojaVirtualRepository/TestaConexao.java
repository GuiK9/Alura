package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaConexao {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/loja_virtual", "root",
                    "root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
