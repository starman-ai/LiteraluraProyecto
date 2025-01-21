package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    /**
     * Lista todos los autores junto con sus libros.
     *
     * @return Lista de todos los autores incluyendo sus libros asociados.
     */
    public List<Autor> listarAutores() {
        return autorRepository.findAllConLibros();
    }

    /**
     * Lista autores vivos en un año específico junto con sus libros.
     *
     * @param ano Año específico para filtrar autores vivos.
     * @return Lista de autores vivos en el año indicado junto con sus libros.
     */
    public List<Autor> listarAutoresVivosEnAno(int ano) {
        return autorRepository.findAutoresVivosEnAnoConLibros(ano);
    }

    /**
     * Crea un nuevo autor en la base de datos.
     *
     * @param autor Objeto Autor con los datos del autor a crear.
     * @return Autor creado y almacenado en la base de datos.
     */
    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Obtiene un autor por su ID.
     *
     * @param id Identificador único del autor.
     * @return Autor encontrado o un Optional vacío si no existe.
     */
    public Optional<Autor> obtenerAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    /**
     * Obtiene un autor por su nombre.
     *
     * @param nombre Nombre del autor a buscar.
     * @return Autor encontrado o un Optional vacío si no existe.
     */
    public Optional<Autor> obtenerAutorPorNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }

    /**
     * Actualiza los detalles de un autor existente.
     *
     * @param id Identificador único del autor a actualizar.
     * @param autorDetalles Objeto Autor con los nuevos datos.
     * @return Autor actualizado y almacenado en la base de datos.
     * @throws RuntimeException Si no se encuentra el autor con el ID especificado.
     */
    public Autor actualizarAutor(Long id, Autor autorDetalles) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no Encontrado"));
        autor.setNombre(autorDetalles.getNombre());
        autor.setAnoNacimiento(autorDetalles.getAnoNacimiento());
        autor.setAnoFallecimiento(autorDetalles.getAnoFallecimiento());
        return autorRepository.save(autor);
    }

    /**
     * Elimina un autor por su ID.
     *
     * @param id Identificador único del autor a eliminar.
     */
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
