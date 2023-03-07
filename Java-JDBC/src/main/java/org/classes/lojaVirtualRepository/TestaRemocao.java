package org.classes.lojaVirtualRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().recuperarconexao();

        Statement stm = con.createStatement();
        stm.execute("DELETE from PRODUTO WHERE id > 3");
        int linhasModificadas = stm.getUpdateCount();
        System.out.println("quantidade de linhas que foram excluidas: " + linhasModificadas);
//        while (econtradoParaDelete.next()){
//            System.out.println(econtradoParaDelete.getInt("id"));
//        }
    }
}
