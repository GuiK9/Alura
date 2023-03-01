package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String stringConexcao = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "12321";

        try {
            Connection con = DriverManager.getConnection(stringConexcao, usuario, senha);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM playground";
            String sql2 =  "INSERT INTO playground (type, color, location, install_date) VALUES ('lock',  'red', 'north', '2015-03-12')";
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString("type"));
            }

            int resultUpdate = stmt.executeUpdate(sql2);
            System.out.println(resultUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        };

    }

}