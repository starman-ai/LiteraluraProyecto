package com.alura.literalura.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoAPI {

    /**
     * Realiza una solicitud HTTP GET a una URL específica y obtiene los datos en formato JSON.
     *
     * @param url Dirección URL de la API desde donde se obtendrán los datos.
     * @return Respuesta en formato JSON como cadena de texto.
     * @throws RuntimeException Si ocurre un error de E/S o si la solicitud es interrumpida.
     */
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient(); // Cliente HTTP

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build(); // Construcción de la solicitud HTTP GET

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body(); // Respuesta en formato de cadena de texto
        } catch (IOException e) {
            throw new RuntimeException("Error de E/S al obtener datos de la API", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("La solicitud fue interrumpida", e);
        }
    }
}
