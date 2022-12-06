package br.com.alura.tdd.service;


import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho){

        BigDecimal aumento = switch (desempenho) {
            case A_DESEJAR -> funcionario.getSalario().multiply(new BigDecimal("0.03"));
            case BOM -> funcionario.getSalario().multiply(new BigDecimal("0.15"));
            case OTIMO -> funcionario.getSalario().multiply(new BigDecimal("0.20"));
            default -> throw new IllegalStateException("Unexpected value: " + desempenho);
        };


        funcionario.reajustarSalario(aumento);
    }
}
