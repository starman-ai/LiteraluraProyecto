package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

//     Encuentra un libro por su título, ignorando mayúsculas y minúsculas.
//     Título del libro.
//     Optional con el libro encontrado, o vacío si no se encuentra.
    Optional<Libro> findByTituloIgnoreCase(String titulo);

//     Encuentra libros por su idioma.
//     Idioma de los libros.
//     Lista de libros en el idioma especificado.
    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> findByIdioma(@Param("idioma") String idioma);
}