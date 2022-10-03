
import br.com.bytebank.banco.modelo.*;


public class TesteBiblioteca {
    public static void main(String[] args) {
        Conta c = new ContaCorrente(122, 321);
        c.deposita(122);

        System.out.println(c);
    }
    
}