package org.classes.lojaVirtualRepository;

import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection con = factory.recuperarconexao()) {

            con.setAutoCommit(false);

            try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                adicionarVariavel(stm, "MOUSE", "SEM FIO");
                adicionarVariavel(stm, "SMARTTV", "50 POLEGADAS");
                adicionarVariavel(stm, "RADIO", "RÁDIO A BATERIA");
                con.commit();
            } catch (Exception e) {
                e.printStackTrace();
                con.rollback();
                System.out.println("ROLLBACK FOI EXECUTADO");
            }
        }
    }

    private static void adicionarVariavel(PreparedStatement stm, String nome, String descricao) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if(nome.equals("RADIO")) throw new RuntimeException("Não foi possível adicionar o produto");

        stm.execute();
        try(ResultSet rst = stm.getGeneratedKeys()){
            while(rst.next()) {
                int id = rst.getInt(1);
                System.out.println("o id criado foi " + id);
            }
        }
    }
}
