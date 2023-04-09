package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.RegraDeNegocioException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

public class ContaService {
    private ConnectionFactory connection;

    public ContaService(){
        this.connection = new ConnectionFactory();
    }

    public Set<Conta> listarContasAbertas() {
        Connection conn = connection.recuperarConexao();
        return new ContaDAO(conn).listar();
    }

    public BigDecimal consultarSaldo(Integer numeroDaConta) {
        var conta = buscarPorNumero(numeroDaConta);
        return conta.getSaldo();
    }

    public void abrir(DadosAberturaConta dadosDaConta) {
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).salvar(dadosDaConta);
    }

    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) {
        var conta = buscarPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }

        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }

        conta.sacar(valor);
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).alterar(conta.getNumero(), conta.getSaldo());
    }

    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) {
        Conta conta = buscarPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do deposito deve ser superior a zero!");
        }
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).alterar(conta.getNumero(), valor.add(conta.getSaldo()));
    }

    public void realizarTransferencia(Integer numeroDaContaOrigem, Integer numeroDaContaDestino, BigDecimal saldo) {
        ContaDAO DAO = new ContaDAO(connection.recuperarConexao());
        try{
            Conta contaOrigem = DAO.listarPorNumero(numeroDaContaOrigem);
            Conta contaDestino = DAO.listarPorNumero(numeroDaContaDestino);
            contaOrigem.sacar(saldo);
            contaDestino.depositar(saldo);
            DAO.alterar(contaOrigem.getNumero(), contaOrigem.getSaldo());
            DAO.alterar(contaDestino.getNumero(), contaDestino.getSaldo());
        } catch (Exception E){
            throw new RuntimeException(E);
        }


    }

    public Conta buscarPorNumero(Integer numero) {
        return new ContaDAO(connection.recuperarConexao()).listarPorNumero(numero);
    }

    public void encerrar(Integer numeroDaConta) {
        var conta = buscarPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }
        new ContaDAO(connection.recuperarConexao()).deletar(numeroDaConta);
    }

}
