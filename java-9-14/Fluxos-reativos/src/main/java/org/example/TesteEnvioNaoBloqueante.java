package org.example;

import org.example.model.NotaFiscal;
import org.example.wsclient.NotaFiscalWSClient;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;



public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		Executor newFixedThreadPool = Executors.newFixedThreadPool(3);
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(newFixedThreadPool, 1);
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		publisher.consume(nfwsc::enviar);
		publisher.consume(data -> {
			System.out.println("A thread do TesteEnvioNãaBloquante é: " + Thread.currentThread().getName());
		});
		publisher.consume(data -> {
			System.out.println("A thread do TesteEnvioNãaBloquante é: " + Thread.currentThread().getName());
		});
		publisher.submit(primeiraNotaFiscal);
		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
