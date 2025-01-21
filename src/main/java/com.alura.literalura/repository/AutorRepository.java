package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

//    Encuentra un autor por su nombre.
//    Nombre Nombre del autor.
//    Optional con el autor encontrado, o vacío si no se encuentra.
    Optional<Autor> findByNombre(String nombre);

//     Encuentra autores vivos en un año específico junto con sus libros.
//     ano Año para buscar autores vivos.
//     Lista de autores vivos en el año especificado junto con sus libros.
    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE (a.anoFallecimiento IS NULL OR a.anoFallecimiento > :ano) AND a.anoNacimiento <= :ano")
    List<Autor> findAutoresVivosEnAnoConLibros(@Param("ano") int ano);

//     Encuentra todos los autores junto con sus libros.
//     Lista de todos los autores junto con sus libros.
    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros")
    List<Autor> findAllConLibros();
}