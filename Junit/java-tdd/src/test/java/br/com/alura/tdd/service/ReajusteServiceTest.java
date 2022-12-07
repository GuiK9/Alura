package br.com.alura.tdd.service;

import br.com.alura.tdd.exceptions.SalarioMuitoAltoException;
import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000.00"));;
    }

    @Test
    void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerQuinzePorCentoQuanoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    void DeveDarExceptionPorSalarioSerMuitoAlto() {
        this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000"));
        Assertions.assertThrows(SalarioMuitoAltoException.class, () -> service.concederReajuste(funcionario, Desempenho.OTIMO)
        );
    }
}



