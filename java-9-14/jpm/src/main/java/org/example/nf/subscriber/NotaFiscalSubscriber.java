package org.example.nf.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.example.modelo.dominio.NotaFiscal;
import org.example.nf.servico.NotaFiscalServico;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(NotaFiscal nf) {
		NotaFiscalServico.emitir(nf);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Notas emitidas com sucesso!!");
	}
}
