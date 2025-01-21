package com.alura.literalura.service;

/**
 * Interfaz para definir un metodo genérico que convierte cadenas JSON en objetos.
 */
public interface IConvierteDatos {

    /**
     * Convierte una cadena JSON en un objeto de la clase especificada.
     *
     * @param json  Cadena JSON a deserializar.
     * @param clase Clase del objeto que se quiere obtener.
     * @param <T>   Tipo genérico del objeto a devolver.
     * @return Objeto deserializado de la clase especificada.
     */
    <T> T obtenerDatos(String json, Class<T> clase);
}
