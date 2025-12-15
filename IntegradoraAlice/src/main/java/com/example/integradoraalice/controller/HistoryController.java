package com.example.integradoraalice.controller;

import com.example.integradoraalice.Model.Book;
import com.example.integradoraalice.Model.HistoryAction;
import com.example.integradoraalice.Model.Loan;
import com.example.integradoraalice.Structures.ArrayQueue;
import com.example.integradoraalice.service.BookService;
import com.example.integradoraalice.service.HistoryService;
import com.example.integradoraalice.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {private final HistoryService historyService;
    private final LoanService loanService;
    private final BookService bookService;

    public HistoryController(HistoryService historyService, LoanService loanService, BookService bookService) {
        this.historyService = historyService;
        this.loanService = loanService;
        this.bookService = bookService;
    }

    @PostMapping("/undo")
    public ResponseEntity<String> undo() {

        if (historyService.isEmpty())
            return ResponseEntity.badRequest().body("No hay acciones para deshacer");

        HistoryAction h = historyService.pop();

        if (h.getActionType().equals("CREATE_LOAN")) {

            Loan loan = loanService.buscarPrestamoPorId(h.getLoanId());
            if (loan != null)
                loanService.eliminarPrestamo(loan);

            Book book = bookService.busquedaPorId(h.getBookId());
            book.setAvailableCopies(h.getPreviousAvailableCopies());

            return ResponseEntity.ok("Se deshizo la creación del préstamo");
        }

        if (h.getActionType().equals("ADD_TO_WAITLIST")) {

            Book book = bookService.busquedaPorId(h.getBookId());
            ArrayQueue<Integer> vieja = book.getWaitList();
            ArrayQueue<Integer> nueva = new ArrayQueue<>(50);

            while (!vieja.isEmpty()) {
                int u = vieja.poll();
                if (u != h.getUserId())
                    nueva.offer(u);
            }

            book.setWaitList(nueva);

            return ResponseEntity.ok(
                    "Se deshizo la reserva del usuario");
        }

        return ResponseEntity.ok("Acción no válida");
    }

    @GetMapping
    public ResponseEntity<Object[]> getHistory() {
        return ResponseEntity.ok(
                historyService.getStack().mostrarLista()
        );
    }
}

