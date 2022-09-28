public class TesteSaca {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente(123, 111);
        conta.deposita(200);
        try {
            conta.saca(290);
        } catch (Exception e) {
           e.printStackTrace();
        }
        

        System.out.println(conta.getSaldo());
    }
}
