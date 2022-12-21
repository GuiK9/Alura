package main.java.org.example.wsclient;


import main.java.org.example.model.NotaFiscal;

public class NotaFiscalWSClient {

	public void enviar(NotaFiscal nf) {
		try {
			System.out.println("Emitindo nota fiscal");
			Thread.sleep(5000);
			System.out.format("Nota fiscal emitida %nEm nome de %s %nNa data de %s %n", 
					nf.getNome(), nf.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
