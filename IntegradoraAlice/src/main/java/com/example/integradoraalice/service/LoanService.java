package com.example.integradoraalice.service;

import com.example.integradoraalice.Model.Book;
import com.example.integradoraalice.Model.Loan;
import com.example.integradoraalice.Structures.ArrayQueue;
import com.example.integradoraalice.Structures.ArrayStack;
import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.Structures.Node;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final CatalogoSyngleLinkedList prestamos = new CatalogoSyngleLinkedList();
    private final ArrayStack<String> historial = new ArrayStack<>();
    private int proximoIdPrestamo = 1;

    private final BookService servicioLibros;
    private final UserService servicioUsuarios;

    public LoanService(BookService servicioLibros, UserService servicioUsuarios) {
        this.servicioLibros = servicioLibros;
        this.servicioUsuarios = servicioUsuarios;
    }
    // CREAR PRÉSTAMO
    public String crearPrestamo(int idUsuario, int idLibro) {

        Book libro = servicioLibros.busquedaPorId(idLibro);
        if (libro == null)
            return "Libro no encontrado";

        if (servicioUsuarios.buscarPorId(idUsuario) == null)
            return "Usuario no encontrado";

        if (libro.getAvailableCopies() > 0) {

            Loan nuevo = new Loan(proximoIdPrestamo++, idUsuario, idLibro, "ACTIVE");
            prestamos.add(nuevo);

            libro.setAvailableCopies(libro.getAvailableCopies() - 1);

            historial.push("CREATE_LOAN:" + nuevo.getId());
            return "Préstamo creado correctamente";
        }

        // Si no hay copias → agregar a lista de espera
        libro.getWaitList().offer(idUsuario);
        historial.push("ADD_TO_WAITLIST:" + idUsuario + ":" + idLibro);
        return "No hay copias. Usuario agregado a lista de espera";
    }
    // DEVOLVER LIBRO
    public String devolverLibro(int idPrestamo) {

        var actual = prestamos.head;

        while (actual != null) {
            Loan p = (Loan) actual.data;

            if (p.getId() == idPrestamo && p.getStatus().equals("ACTIVE")) {

                p.setStatus("RETURNED");

                Book libro = servicioLibros.busquedaPorId(p.getBookId());
                if (libro == null)
                    return "Libro no encontrado";

                // Hay lista de espera?
                if (!libro.getWaitList().isEmpty()) {

                    int siguienteUsuario = libro.getWaitList().poll();

                    Loan prestamoAuto = new Loan(
                            proximoIdPrestamo++,
                            siguienteUsuario,
                            libro.getId(),
                            "ACTIVE"
                    );

                    prestamos.add(prestamoAuto);

                    historial.push("AUTO_LOAN:" + prestamoAuto.getId());

                    return "Devuelto. Préstamo automático para usuario " + siguienteUsuario;
                }

                // Si no hay lista de espera → incrementar copias
                libro.setAvailableCopies(libro.getAvailableCopies() + 1);

                historial.push("RETURN_LOAN:" + p.getId());
                return "Libro devuelto correctamente";
            }

            actual = actual.next;
        }

        return "Préstamo no encontrado";
    }
    // OBTENER PRÉSTAMOS ACTIVOS
    public CatalogoSyngleLinkedList obtenerPrestamosActivos() {
        CatalogoSyngleLinkedList activos = new CatalogoSyngleLinkedList();
        var actual = prestamos.head;

        while (actual != null) {
            Loan p = (Loan) actual.data;
            if (p.getStatus().equals("ACTIVE"))
                activos.add(p);

            actual = actual.next;
        }

        return activos;
    }
    // OBTENER PRESTAMOS POR USUARIO
    public CatalogoSyngleLinkedList obtenerPrestamosPorUsuario(int idUsuario) {

        CatalogoSyngleLinkedList lista = new CatalogoSyngleLinkedList();
        var actual = prestamos.head;

        while (actual != null) {
            Loan p = (Loan) actual.data;
            if (p.getUserId() == idUsuario)
                lista.add(p);

            actual = actual.next;
        }

        return lista;
    }
    // OBTENER POSICIÓN EN LISTA DE ESPERA
    public int obtenerPosicionReserva(int idLibro, int idUsuario) {
        Book libro = servicioLibros.busquedaPorId(idLibro);
        if (libro == null)
            return -1;
        ArrayQueue<Integer> cola = libro.getWaitList();
        int posicion = 1;
        ArrayQueue<Integer> aux = new ArrayQueue<>(50);

        int encontrado = -1;

        while (!cola.isEmpty()) {
            int u = cola.poll();
            aux.offer(u);

            if (u == idUsuario && encontrado == -1)
                encontrado = posicion;

            posicion++;
        }

        // restaurar cola original
        while (!aux.isEmpty())
            cola.offer(aux.poll());

        return encontrado;
    }
    // CANCELAR RESERVA
    public String cancelarReserva(int idLibro, int idUsuario) {

        Book libro = servicioLibros.busquedaPorId(idLibro);
        if (libro == null)
            return "Libro no encontrado";

        ArrayQueue<Integer> vieja = libro.getWaitList();
        ArrayQueue<Integer> nueva = new ArrayQueue<>(50);

        boolean removido = false;

        while (!vieja.isEmpty()) {
            int valor = vieja.poll();
            if (valor == idUsuario)
                removido = true;
            else
                nueva.offer(valor);
        }

        libro.setWaitList(nueva);

        return removido ? "Reserva cancelada" : "Usuario no estaba en lista";
    }
    // HISTORIAL (STACK)
    public ArrayStack<String> obtenerPilaHistorial() {
        return historial;
    }
    // BUSCAR PRÉSTAMO POR ID
    public Loan buscarPrestamoPorId(int id) {

        var actual = prestamos.head;

        while (actual != null) {
            Loan p = (Loan) actual.data;
            if (p.getId() == id)
                return p;

            actual = actual.next;
        }

        return null;
    }
    // ELIMINAR PRÉSTAMO
    public void eliminarPrestamo(Loan p) {
        Node actual = prestamos.head;
        Node anterior = null;
        while (actual != null) {
            if (actual.data == p) {
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
}