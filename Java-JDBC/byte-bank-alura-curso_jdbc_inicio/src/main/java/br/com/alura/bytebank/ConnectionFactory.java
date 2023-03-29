package br.com.alura.bytebank;
import java.sql.*;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/byte_bank", "root", "12345678");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}