package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvierteDatos implements IConvierteDatos {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Objeto para manejar la conversión JSON.

    /**
     * Convierte una cadena JSON en un objeto de la clase especificada.
     *
     * @param json  Cadena JSON a deserializar.
     * @param clase Clase del objeto que se quiere obtener.
     * @param <T>   Tipo genérico del objeto a devolver.
     * @return Objeto deserializado de la clase especificada.
     * @throws RuntimeException Si ocurre un error durante la deserialización del JSON.
     */
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase); // Convierte JSON a objeto.
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al deserializar el JSON", e);
        }
    }
}
