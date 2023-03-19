package org.classes.lojaVirtualRepository;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class ConnectionFactory {

    public DataSource dataSource;
    public ConnectionFactory (){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("12345678");
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }
    public Connection recuperarconexao() throws SQLException {
        return this.dataSource.getConnection();
    }
}
