package main.java.org.example;



import main.java.org.example.model.NotaFiscal;
import main.java.org.example.subscriber.NotaFiscalSubscriber;
import main.java.org.example.wsclient.NotaFiscalWSClient;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;



public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		NotaFiscal segundaNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		NotaFiscal terceiraNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		NotaFiscal quartaNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
		publisher.subscribe(subscriber);
		publisher.submit(primeiraNotaFiscal);
		publisher.submit(segundaNotaFiscal);
		publisher.submit(terceiraNotaFiscal);
		publisher.submit(quartaNotaFiscal);
		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
