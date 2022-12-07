package br.com.alura.tdd.service;


import br.com.alura.tdd.exceptions.SalarioMuitoAltoException;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho){

        BigDecimal salario = funcionario.getSalario();

        if(salario.doubleValue() > 10000){
            throw new SalarioMuitoAltoException(salario);
        }

        BigDecimal aumento = switch (desempenho) {
            case A_DESEJAR -> salario.multiply(new BigDecimal("0.03"));
            case BOM -> salario.multiply(new BigDecimal("0.15"));
            case OTIMO -> salario.multiply(new BigDecimal("0.20"));
        };


        funcionario.reajustarSalario(aumento);
    }
}
