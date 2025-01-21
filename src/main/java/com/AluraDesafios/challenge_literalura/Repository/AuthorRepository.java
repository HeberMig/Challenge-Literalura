package com.AluraDesafios.challenge_literalura.Repository;

import com.AluraDesafios.challenge_literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByNombreIgnoreCase(String nombre);


    List<Author> findByAnioNacimientoLessThanEqualAndAnioMuerteGreaterThan(int anio, int anio2);


    List<Author> findByAnioNacimientoLessThanEqualAndAnioMuerte(int anio, int anioMuerte);

}
