package com.example.integradoraalice.service;

import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.Model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final CatalogoSyngleLinkedList catalogo = new CatalogoSyngleLinkedList();
    private int nextId = 5;

    public BookService() {
        catalogo.add(new Book(1, "Un Mundo Feliz", "Aldous Huxley", 2, true));
        catalogo.add(new Book(2, "Orgullo y Prejuicio", "Jane Austen", 2, true));
        catalogo.add(new Book(3, "El Principito", "Antoine de Saint-Exupéry", 2, true));
        catalogo.add(new Book(4, "Crónica de una Muerte", "Gabriel García Márquez",2,true));
    }

    public String agregarLibro(Book libro) {
        libro.setId(nextId);
        if (busquedaPorId(libro.getId()) != null)
            return "Ya existe un libro con ese ID";

        catalogo.add(libro);
        nextId++;
        return "Libro registrado";
    }

    public CatalogoSyngleLinkedList obtenerTodos() {
        return catalogo;
    }

    public Book busquedaPorId(int id) {
        var actual = catalogo.head;
        while (actual != null) {
            Book libro = (Book) actual.data;
            if (libro.getId() == id)
                return libro;
            actual = actual.next;
        }
        return null;
    }

    public Book busquedaPorTitulo(String titulo) {
        var actual = catalogo.head;
        while (actual != null) {
            Book libro = (Book) actual.data;
            if (libro.getTitle() != null && libro.getTitle().equalsIgnoreCase(titulo))
                return libro;
            actual = actual.next;
        }
        return null;
    }

    public String actualizarLibro(int id, Book nuevosDatos) {
        Book libro = busquedaPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setTitle(nuevosDatos.getTitle());
        libro.setAuthor(nuevosDatos.getAuthor());
        libro.setTotalCopies(nuevosDatos.getTotalCopies());

        if (libro.getAvailableCopies() > libro.getTotalCopies())
            libro.setAvailableCopies(libro.getTotalCopies());

        libro.setStatus(nuevosDatos.isStatus());

        return "Libro actualizado";
    }

    public String cambioEstado(int id) {
        Book libro = busquedaPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setStatus(!libro.isStatus());
        return "Estado actualizado";
    }

    public String darDeBaja(int id) {
        Book libro = busquedaPorId(id);
        if (libro == null)
            return "Libro no encontrado";

        libro.setStatus(false);
        return "Libro dado de baja";
    }
}
