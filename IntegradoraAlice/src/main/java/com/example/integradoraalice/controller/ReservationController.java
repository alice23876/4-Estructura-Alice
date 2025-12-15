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


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final LoanService loanService;
    private final BookService bookService;
    private final UserService userService;

    public ReservationController(LoanService loanService,BookService bookService,UserService userService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getWaitlist(@PathVariable int bookId) {

        Book libro = bookService.busquedaPorId(bookId);
        if (libro == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");

        ArrayQueue<Integer> cola = libro.getWaitList();
        ArrayQueue<Integer> aux = new ArrayQueue<>(50);

        int size = cola.size();

        int[] posiciones = new int[size];
        int[] userIds = new int[size];
        String[] userNames = new String[size];

        int pos = 1;
        int i = 0;

        while (!cola.isEmpty()) {
            int uid = cola.poll();
            aux.offer(uid);

            UserRequest u = userService.buscarPorId(uid);

            posiciones[i] = pos++;
            userIds[i] = uid;
            userNames[i] = (u != null) ? u.getName() : null;

            i++;
        }
        while (!aux.isEmpty())
            cola.offer(aux.poll());

        Object[] response = new Object[] { bookId, posiciones, userIds, userNames};

        return ResponseEntity.ok(response);
    }

    @GetMapping("/position")
    public ResponseEntity<?> getPosition(@RequestParam int bookId,
                                         @RequestParam int userId) {

        int pos = loanService.obtenerPosicionReserva(bookId, userId);

        if (pos == -1)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado o usuario no está en la lista");

        return ResponseEntity.ok(pos);
    }

    @DeleteMapping
    public ResponseEntity<String> cancelarReserva(@RequestParam int userId,
                                                  @RequestParam int bookId) {

        String resultado = loanService.cancelarReserva(bookId, userId);

        if ("Reserva cancelada".equals(resultado))
            return ResponseEntity.ok(resultado);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(resultado);
    }
}
