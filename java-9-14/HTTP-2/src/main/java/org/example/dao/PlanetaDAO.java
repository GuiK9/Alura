package org.example.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class PlanetaDAO {

	public void listar() throws URISyntaxException {
		HttpClient httpClient = HttpClient.newBuilder().build();

		CompletableFuture<HttpResponse<String>> resp = httpClient.sendAsync(
				HttpRequest.newBuilder().uri(new URI("http://localhost:8080/planetas")).GET().build(),
				BodyHandlers.ofString())
				.whenComplete((s, t) -> {
					System.out.println(s.body());
				});

	}
}
