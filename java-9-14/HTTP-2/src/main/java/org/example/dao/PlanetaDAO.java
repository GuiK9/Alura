package org.example.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PlanetaDAO {

	public void listar() throws URISyntaxException, IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder().build();

		HttpResponse<String> send = httpClient.send(
				HttpRequest.newBuilder().uri(new URI("http://localhost:8080/planetas")).GET().build(),
				BodyHandlers.ofString());

		System.out.println(send.body());
	}
}
