package br.com.alura.tdd.service;


import br.com.alura.tdd.exceptions.SalarioMuitoAltoException;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho){
        if(funcionario.getSalario().doubleValue() >= 10000){
            throw new SalarioMuitoAltoException(funcionario.getSalario());
        }
        BigDecimal percentual = desempenho.percentualReajuste();
        funcionario.reajustarSalario(percentual);

    }
}
