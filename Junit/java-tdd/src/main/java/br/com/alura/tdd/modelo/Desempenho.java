package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    OTIMO{
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.2");
        }
    }, BOM{
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.15");
        }
    }, A_DESEJAR{
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.03");
        }
    };

    public abstract BigDecimal percentualReajuste();
}
