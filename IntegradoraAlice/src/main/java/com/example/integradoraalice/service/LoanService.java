package com.example.integradoraalice.service;

import com.example.integradoraalice.Model.Book;
import com.example.integradoraalice.Model.HistoryAction;
import com.example.integradoraalice.Model.Loan;
import com.example.integradoraalice.Structures.ArrayQueue;
import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.Structures.Node;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final CatalogoSyngleLinkedList prestamos = new CatalogoSyngleLinkedList();
    private int proximoIdPrestamo = 1;

    private final BookService bookService;
    private final UserService userService;
    private final HistoryService historyService;

    public LoanService(BookService bookService, UserService userService, HistoryService historyService) {
        this.bookService = bookService;
        this.userService = userService;
        this.historyService = historyService;
    }

    // CREAR PRÉSTAMO
    public String crearPrestamo(int userId, int bookId) {

        Book book = bookService.busquedaPorId(bookId);
        if (book == null)
            return "Libro no encontrado";

        if (userService.buscarPorId(userId) == null)
            return "Usuario no encontrado";

        if (book.getAvailableCopies() > 0) {

            int copiasAntes = book.getAvailableCopies();

            Loan loan = new Loan(proximoIdPrestamo++, userId, bookId, "ACTIVE");
            prestamos.add(loan);

            book.setAvailableCopies(copiasAntes - 1);

            // para undo
            historyService.push(
                    new HistoryAction(
                            "CREATE_LOAN",
                            loan.getId(),
                            bookId,
                            copiasAntes
                    )
            );

            return "Préstamo creado correctamente";
        }

        // mi lista de espera
        book.getWaitList().offer(userId);

        historyService.push(
                new HistoryAction(
                        "ADD_TO_WAITLIST",
                        bookId,
                        userId
                )
        );

        return "Usuario agregado a lista de espera";
    }
    public Loan buscarPrestamoPorId(int id) {
        var actual = prestamos.head;
        while (actual != null) {
            Loan l = (Loan) actual.data;
            if (l.getId() == id)
                return l;
            actual = actual.next;
        }
        return null;
    }

    public void eliminarPrestamo(Loan loan) {
        Node actual = prestamos.head;
        Node anterior = null;

        while (actual != null) {
            if (actual.data == loan) {
                if (anterior == null)
                    prestamos.head = actual.next;
                else
                    anterior.next = actual.next;
                return;
            }
            anterior = actual;
            actual = actual.next;
        }
    }
    public String devolverLibro(int idPrestamo) {

        Node actual = prestamos.head;

        while (actual != null) {

            Loan loan = (Loan) actual.data;

            if (loan.getId() == idPrestamo &&
                    loan.getStatus().equals("ACTIVE")) {

                loan.setStatus("RETURNED");

                Book book = bookService.busquedaPorId(loan.getBookId());
                if (book == null)
                    return "Libro no encontrado";

                // Si hay usuarios en lista de espera
                if (!book.getWaitList().isEmpty()) {

                    int siguienteUsuario = book.getWaitList().poll();

                    Loan nuevo = new Loan(
                            proximoIdPrestamo++,
                            siguienteUsuario,
                            book.getId(),
                            "ACTIVE"
                    );

                    prestamos.add(nuevo);

                    return "Libro devuelto y préstamo reasignado al usuario "
                            + siguienteUsuario;
                }
                book.setAvailableCopies(
                        book.getAvailableCopies() + 1
                );

                return "Libro devuelto correctamente";
            }

            actual = actual.next;
        }

        return "Préstamo no encontrado o ya devuelto";
    }
    public CatalogoSyngleLinkedList obtenerPrestamosActivos() {

        CatalogoSyngleLinkedList activos =
                new CatalogoSyngleLinkedList();

        Node actual = prestamos.head;

        while (actual != null) {

            Loan loan = (Loan) actual.data;

            if (loan.getStatus().equals("ACTIVE")) {
                activos.add(loan);
            }

            actual = actual.next;
        }

        return activos;
    }
    public CatalogoSyngleLinkedList obtenerPrestamosPorUsuario(int idUsuario) {

        CatalogoSyngleLinkedList lista =
                new CatalogoSyngleLinkedList();

        Node actual = prestamos.head;

        while (actual != null) {

            Loan loan = (Loan) actual.data;

            if (loan.getUserId() == idUsuario) {
                lista.add(loan);
            }

            actual = actual.next;
        }

        return lista;
    }
    public int obtenerPosicionReserva(int bookId, int userId) {

        Book book = bookService.busquedaPorId(bookId);
        if (book == null)
            return -1;

        ArrayQueue<Integer> cola = book.getWaitList();
        ArrayQueue<Integer> aux = new ArrayQueue<>(50);

        int posicion = 1;
        int encontrada = -1;

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            aux.offer(actual);

            if (actual == userId && encontrada == -1)
                encontrada = posicion;

            posicion++;
        }
        //restaura la cola originak
        while (!aux.isEmpty())
            cola.offer(aux.poll());

        return encontrada;
    }
    public String cancelarReserva(int bookId, int userId) {

        Book book = bookService.busquedaPorId(bookId);
        if (book == null)
            return "Libro no encontrado";

        ArrayQueue<Integer> vieja = book.getWaitList();
        ArrayQueue<Integer> nueva = new ArrayQueue<>(50);

        boolean eliminado = false;

        while (!vieja.isEmpty()) {
            int actual = vieja.poll();
            if (actual == userId)
                eliminado = true;
            else
                nueva.offer(actual);
        }

        book.setWaitList(nueva);

        if (eliminado) {
            return "Reserva cancelada";
        } else {
            return "Usuario no estaba en la lista";
        }
    }
}
