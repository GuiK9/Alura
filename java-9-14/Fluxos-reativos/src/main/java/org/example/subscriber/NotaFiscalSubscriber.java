package main.java.org.example.subscriber;

import main.java.org.example.model.NotaFiscal;
import main.java.org.example.wsclient.NotaFiscalWSClient;

import java.util.concurrent.Flow.*;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Chamando o onSubscriber");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal notaFiscal) {
        NotaFiscalWSClient notaFiscalWSClient = new NotaFiscalWSClient();
        notaFiscalWSClient.enviar(notaFiscal);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Todas as notas foram emitidas");
    }
}
