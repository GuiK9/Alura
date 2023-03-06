package org.classes.lojaVirtualRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarconexao() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root",
                "12345678");
        return connection;
    }
}
