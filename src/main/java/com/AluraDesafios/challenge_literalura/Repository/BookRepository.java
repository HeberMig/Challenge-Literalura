package com.AluraDesafios.challenge_literalura.Repository;

import com.AluraDesafios.challenge_literalura.model.Book;
import com.AluraDesafios.challenge_literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIdiomas(Language idioma);
}
