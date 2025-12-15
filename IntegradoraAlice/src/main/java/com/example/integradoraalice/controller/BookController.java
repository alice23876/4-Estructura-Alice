package com.example.integradoraalice.controller;

import com.example.integradoraalice.Model.Book;
import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.dto.BookRequest;
import com.example.integradoraalice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    //Se inicializa el servicio
    private final BookService servicio;

    public BookController(BookService servicio) {
        this.servicio = servicio;
    }
    private BookRequest aDTO(Book libro) {
        return new BookRequest(
                libro.getId(),
                libro.getTitle(),
                libro.getAuthor(),
                libro.getTotalCopies(),
                libro.getAvailableCopies()
        );
    }
    private Book modelo(BookRequest dto) {
        return new Book(
                0,
                dto.getTitle(),
                dto.getAuthor(),
                dto.getTotalCopies(),
                true
        );
    }
    @PostMapping
    public ResponseEntity<String> crear(@RequestBody BookRequest solicitud) {
        return ResponseEntity.ok(servicio.agregarLibro(modelo(solicitud)));
    }

    @GetMapping//Lista de todos los libros
    public ResponseEntity<CatalogoSyngleLinkedList> encontrarTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRequest> encontrarPorId(@PathVariable int id) {
        Book libro = servicio.busquedaPorId(id);
        if (libro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(aDTO(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody BookRequest solicitud) {
        Book actualizado = modelo(solicitud);
        actualizado.setId(id);
        String resultado = servicio.actualizarLibro(id, actualizado);
        if (resultado.equals("Libro no encontrado")) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> cambiarEstadoLogico(@PathVariable int id) {
        String resultado = servicio.cambioEstado(id);
        if (resultado.equals("Libro no encontrado")) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/search")
    public ResponseEntity<BookRequest> buscarPorTitulo(@RequestParam String title) {
        Book libro = servicio.busquedaPorTitulo(title);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aDTO(libro));
    }
}

