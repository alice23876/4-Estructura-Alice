package com.example.integradoraalice.controller;

import com.example.integradoraalice.Model.Book;
import com.example.integradoraalice.Structures.ArrayQueue;
import com.example.integradoraalice.dto.UserRequest;
import com.example.integradoraalice.service.BookService;
import com.example.integradoraalice.service.LoanService;
import com.example.integradoraalice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final LoanService loanService;
    private final BookService bookService;
    private final UserService userService;

    public ReservationController(LoanService loanService, BookService bookService, UserService userService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getWaitlist(@PathVariable("bookId") int bookId) {
        Book libro = bookService.busquedaPorId(bookId);
        if (libro == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");

        ArrayQueue<Integer> cola = libro.getWaitList();
        ArrayQueue<Integer> aux = new ArrayQueue<>(50);

        List<Map<String, Object>> waitlist = new ArrayList<>();
        int posicion = 1;

        while (!cola.isEmpty()) {
            int uid = cola.poll();
            aux.offer(uid);

            UserRequest usuario = userService.buscarPorId(uid);
            String name = usuario != null ? usuario.getName() : null;

            Map<String, Object> entry = new HashMap<>();
            entry.put("position", posicion++);
            entry.put("userId", uid);
            entry.put("userName", name);

            waitlist.add(entry);
        }

        // Restaurar cola original
        while (!aux.isEmpty())
            cola.offer(aux.poll());

        Map<String, Object> resp = new HashMap<>();
        resp.put("bookId", bookId);
        resp.put("waitlist", waitlist);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/position")
    public ResponseEntity<?> getPosition(@RequestParam int bookId, @RequestParam int userId) {
        int pos = loanService.obtenerPosicionReserva(bookId, userId);
        if (pos == -1)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado o usuario no está en la lista");

        Map<String, Object> out = new HashMap<>();
        out.put("bookId", bookId);
        out.put("userId", userId);
        out.put("position", pos);
        return ResponseEntity.ok(out);
    }

    @DeleteMapping
    public ResponseEntity<String> cancelarReserva(@RequestParam int userId, @RequestParam int bookId) {
        String resultado = loanService.cancelarReserva(bookId, userId);
        if ("Reserva cancelada".equals(resultado))
            return ResponseEntity.ok(resultado);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
    }
}
