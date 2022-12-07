package br.com.alura.tdd.exceptions;

import java.math.BigDecimal;

public class SalarioMuitoAltoException extends RuntimeException  {
         String messagem;
        BigDecimal salario;

        public SalarioMuitoAltoException(BigDecimal salario){
            String mensagem = "Salario Muito Alto, não recebe reajuste";
        }
        public String getMessagem() {
        return messagem;
    }
}