package org.projeto1.servidor;

import java.io.PrintStream;
import java.util.concurrent.*;

public class TrabalhaResultadosComandoC1EC2 implements Callable<Void> {
    private final PrintStream saidaCliente;
    private final Future<String> futureWS;
    private final Future<String> futureBanco
            ;

    public TrabalhaResultadosComandoC1EC2(Future<String> futureWS, Future<String> futureBanco, PrintStream saidaCliente) {
        this.futureWS = futureWS;
        this.futureBanco = futureBanco;
        this.saidaCliente = saidaCliente;
    }

    @Override
    public Void call() throws Exception {
        System.out.println("Aguradando resultados do Future WS e Banco");
        try {
            String numeroMagicoWS = futureWS.get(10, TimeUnit.SECONDS);
            String numeroMagicoBC = futureBanco.get(10, TimeUnit.SECONDS);

            this.saidaCliente.println("Resultado do comando c2: " + numeroMagicoBC + ", " + numeroMagicoWS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.saidaCliente.println("Timeout: Cancelando a execução do servidor");
            this.saidaCliente.println("Timeout na Execução do comando c2");
            this.futureWS.cancel(true);
            this.futureBanco.cancel(true);
        }

        System.out.println("Finalizou Junta Resultados FutureWS e FutureBanco");

        return null;
    }
}
