package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.RegraDeNegocioException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class ContaService {
    private ConnectionFactory connection;

    public ContaService(){
        this.connection = new ConnectionFactory();
    }

    private Set<Conta> contas = new HashSet<>();

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
        Connection conn = connection.recuperarConexao();
        ContaDAO DAO = new ContaDAO(conn);
        Conta contaOrigem = DAO.listarPorNumero(numeroDaContaOrigem);
        Conta contaDestino = DAO.listarPorNumero(numeroDaContaDestino);
        System.out.println("=======Flag0======");
        contaOrigem.sacar(saldo);
        contaDestino.depositar(saldo);
        DAO.alterar(contaOrigem.getNumero(), contaOrigem.getSaldo());
        System.out.println("=======Flag1======");
        DAO.alterar(contaDestino.getNumero(), contaDestino.getSaldo());
        System.out.println("=======Flag2======");

    }

    public Conta buscarPorNumero(Integer numero) {
        return new ContaDAO(connection.recuperarConexao()).listarPorNumero(numero);
    }

    public void encerrar(Integer numeroDaConta) {
        var conta = buscarPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }
        contas.remove(conta);
    }

}
