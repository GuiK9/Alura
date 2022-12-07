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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BigDecimal bonus = service.calcularBonus(new Funcionario("Marcelo Azevedo De Paula", LocalDate.now(), new BigDecimal("12000")));
        });
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaFuncionarioComSalarioMenorQueMil() {
        BonusService service = new BonusService();
        BigDecimal salario = new BigDecimal("9991.2");
        BigDecimal bonus = service.calcularBonus(new Funcionario("Thiago Braga", LocalDate.now(), salario));
        Assertions.assertEquals(bonus, salario.multiply(new BigDecimal("0.1")));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComMilDeSalario() {
        BonusService service = new BonusService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BigDecimal bonus = service.calcularBonus(new Funcionario("Marcelo Maria", LocalDate.now(), new BigDecimal("10000")));
        });


    }
}
