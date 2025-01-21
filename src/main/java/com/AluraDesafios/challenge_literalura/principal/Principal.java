package com.AluraDesafios.challenge_literalura.principal;

import com.AluraDesafios.challenge_literalura.Repository.AuthorRepository;
import com.AluraDesafios.challenge_literalura.Repository.BookRepository;
import com.AluraDesafios.challenge_literalura.dto.DataBook;
import com.AluraDesafios.challenge_literalura.dto.DataLibreries;
import com.AluraDesafios.challenge_literalura.model.*;
import com.AluraDesafios.challenge_literalura.service.ConsumoAPI;
import com.AluraDesafios.challenge_literalura.service.ConvertirDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumoAPI = new ConsumoAPI();

    private final String URL_BASE = "https://gutendex.com/books/";

    private ConvertirDatos conversor = new ConvertirDatos();

    private List<DataBook> datosBooks = new ArrayList<>();

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    public Principal(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    public void muestraElMenu() {

        var opcion = -1;

        while (opcion != 0) {

            var menu = """
                    1 - Buscar libro por titulo
                    2 - Ver listado de libros
                    3 - Ver listado de autores
                    4 - Listar autores vivos en determinado año
                    5 - Ver cantidad de libros en español e ingles
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarTodosLosLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosPorAnio();
                    break;
                case 5:
                    mostrarEstadisticasPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }


    public void buscarLibroPorTitulo(){

        System.out.print("Ingrese el título del libro que desea buscar: ");
        String titulo = teclado.nextLine();

        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));
        var libreries = conversor.obtenerDatos(json, DataLibreries.class);
        //List<DatosBook> datosBookList = libreries.books();
        DataBook datosBook = libreries.books().get(0);

        Author author = new Author(datosBook.autores().get(0));
        System.out.println(datosBook);
        authorRepository.save(author);
        Book book = new Book(datosBook,author);
        bookRepository.save(book);

    }


    public void listarTodosLosLibros() {

        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
        } else {
            System.out.println("Listado de libros:");
           books.forEach(System.out::println);
        }
    }



    private void listarAutores() {

        List<Author> autores = authorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores en el catálogo.");
        } else {

        }
            System.out.println("Listado de autores:");
        autores.stream()
                .map(author -> String.format(
                        "Nombre: %s, Nacimiento: %d, Fallecimiento: %d",
                        author.getNombre(),
                        author.getAnioNacimiento(),
                        author.getAnioMuerte()
                ))  .forEach(System.out::println);
    }


    private void listarAutoresVivosPorAnio() {

        int anioActual = LocalDate.now().getYear();

        System.out.print("Ingrese un año entre 0 y " + anioActual + ": ");
        int anio;

        try {
            anio = teclado.nextInt();

            if (anio < 0 || anio > anioActual) {
                System.out.println("El año ingresado no es válido. Debe estar entre 0 y " + anioActual + ".");
                return;
            }

            List<Author> autoresVivos = authorRepository.findByAnioNacimientoLessThanEqualAndAnioMuerteGreaterThan(anio, anio);

            autoresVivos.addAll(authorRepository.findByAnioNacimientoLessThanEqualAndAnioMuerte(anio, 0));

            if (autoresVivos.isEmpty()) {
                System.out.println("No se encontraron autores vivos en el año " + anio + ".");
            } else {
                System.out.println("Autores vivos en el año " + anio + ":");
                autoresVivos.stream()
                        .map(author -> String.format(
                                "Nombre: %s, Nacimiento: %d, Fallecimiento: %s",
                                author.getNombre(),
                                author.getAnioNacimiento(),
                                author.getAnioMuerte() == 0 ? "Aún vivo" : author.getAnioMuerte()
                        ))
                        .forEach(System.out::println);
            }

        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es válido. Por favor ingrese un número.");
            teclado.nextLine();
        }

    }


    public void mostrarEstadisticasPorIdioma() {
        List<Book> librosEnEspanol = bookRepository.findByIdiomas(Language.SPANISH);
        System.out.println("Cantidad de libros en español: " + librosEnEspanol.size());

        List<Book> librosEnIngles = bookRepository.findByIdiomas(Language.ENGLISH);
        System.out.println("Cantidad de libros en inglés: " + librosEnIngles.size());
    }

}
