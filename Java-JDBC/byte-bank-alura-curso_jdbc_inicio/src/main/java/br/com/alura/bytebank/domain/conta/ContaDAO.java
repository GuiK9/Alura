package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ContaDAO {

    private  Connection conn;

    ContaDAO(Connection connection) {

        this.conn = connection;
    }

    public void salvar(DadosAberturaConta dadosDaConta)  {

        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), cliente, BigDecimal.ZERO);

        String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email) VALUES (?, ?, ?, ?, ?)";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, conta.getNumero());
            preparedStatement.setBigDecimal(2, conta.getSaldo());
            preparedStatement.setString(3, dadosDaConta.dadosCliente().nome());
            preparedStatement.setString(4, dadosDaConta.dadosCliente().cpf());
            preparedStatement.setString(5, dadosDaConta.dadosCliente().email());
            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Conta> listar() {
     Set<Conta> contas = new HashSet<>();
     String sql = "SELECT * FROM conta";

    try{
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultset = ps.executeQuery();

        while (resultset.next()){
            Integer numero = resultset.getInt(1);
            BigDecimal saldo = resultset.getBigDecimal(2);
            String nome = resultset.getString(3);
            String cpf = resultset.getString(4);
            String email = resultset.getString(5);

            Cliente cliente = new Cliente(new DadosCadastroCliente(nome, cpf, email));
            contas.add(new Conta(numero, cliente, saldo));
        }
        resultset.close();
        ps.close();
        conn.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return contas;
    }

    public Conta listarPorNumero(Integer numero){
        PreparedStatement ps;
        String sql = ("SELECT * FROM conta WHERE numero = ?;");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();


            rs.next();
            Integer numeroDB = rs.getInt(1);
            BigDecimal saldo = rs.getBigDecimal(2);
            String nome = rs.getString(3);
            String cpf = rs.getString(4);
            String email = rs.getString(5);

            Cliente cliente = new Cliente(new DadosCadastroCliente(nome, cpf, email));
            Conta conta = new Conta(numeroDB, cliente, saldo);

            ps.close();
            rs.close();
            conn.close();
            return conta;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Integer numero, BigDecimal valor){
        PreparedStatement ps;
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";

        try{
            ps = conn.prepareStatement(sql);

            ps.setBigDecimal(1, valor);
            ps.setInt(2, numero);
            ps.execute();
            ps.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("===========flag=========");
            throw new RuntimeException(e);
        }
    }
}
