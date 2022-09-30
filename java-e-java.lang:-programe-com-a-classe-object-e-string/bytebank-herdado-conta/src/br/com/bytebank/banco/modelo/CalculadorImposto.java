package br.com.bytebank.banco.modelo;

public class CalculadorImposto {
    private double totalImposto;

    
    /** 
     * @param t
     */
    public void registra(Tributavel t){
        double valor = t.getValorImposto();
        totalImposto += valor;
        
    }

    
    /** 
     * @return double
     */
    public double getTotalImposto() {
        return totalImposto;
    }
    
}
