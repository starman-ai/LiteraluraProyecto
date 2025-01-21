package com.alura.literalura.service;

import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    /**
     * Lista todos los libros disponibles.
     *
     * @return Lista de libros.
     */
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    /**
     * Lista libros filtrados por idioma.
     *
     * @param idioma Idioma de los libros a buscar.
     * @return Lista de libros en el idioma especificado.
     */
    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    /**
     * Crea un nuevo libro en la base de datos.
     *
     * @param libro Objeto Libro a guardar.
     * @return Libro creado.
     */
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    /**
     * Obtiene un libro específico por su ID.
     *
     * @param id ID del libro.
     * @return Objeto Optional con el libro si existe.
     */
    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    /**
     * Obtiene un libro específico por su título, ignorando mayúsculas y minúsculas.
     *
     * @param titulo Título del libro a buscar.
     * @return Objeto Optional con el libro si existe.
     */
    public Optional<Libro> obtenerLibroPorTitulo(String titulo) {
        return libroRepository.findByTituloIgnoreCase(titulo);
    }

    /**
     * Actualiza los detalles de un libro existente.
     *
     * @param id - ID del libro a actualizar.
     * @param libroDetalles - Objeto con los nuevos detalles del libro.
     * @return Libro actualizado.
     * @throws RuntimeException Si el libro no se encuentra.
     */
    public Libro actualizarLibro(Long id, Libro libroDetalles) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setTitulo(libroDetalles.getTitulo());
        libro.setIdioma(libroDetalles.getIdioma());
        libro.setNumeroDescargas(libroDetalles.getNumeroDescargas());
        libro.setAutor(libroDetalles.getAutor());
        return libroRepository.save(libro);
    }

    /**
     * Elimina un libro específico por su ID.
     *
     * @param id ID del libro a eliminar.
     */
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
