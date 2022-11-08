package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTeste {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Marcelo Azevedo De Paula", LocalDate.now(), new BigDecimal("12000")));
        Assertions.assertEquals(new BigDecimal(0), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCento() {
        BonusService service = new BonusService();
        BigDecimal salario = new BigDecimal("991.2");
        BigDecimal bonus = service.calcularBonus(new Funcionario("Thiago Braga", LocalDate.now(), salario));
        Assertions.assertEquals(bonus, salario.multiply(new BigDecimal("0.1")));
    }
}
