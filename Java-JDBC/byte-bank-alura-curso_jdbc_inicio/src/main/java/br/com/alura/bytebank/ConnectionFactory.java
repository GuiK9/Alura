package br.com.alura.bytebank;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        try {
            return createSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/byte_bank");
        config.setUsername("root");
        config.setPassword("12345678");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}