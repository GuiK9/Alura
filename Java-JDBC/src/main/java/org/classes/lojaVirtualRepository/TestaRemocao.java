package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().recuperarconexao();

        PreparedStatement stm = con.prepareStatement("DELETE from PRODUTO WHERE id > ?");
        stm.setInt(1, 3);
        stm.execute();
        int linhasModificadas = stm.getUpdateCount();
        System.out.println("quantidade de linhas que foram excluidas: " + linhasModificadas);
    }
}
