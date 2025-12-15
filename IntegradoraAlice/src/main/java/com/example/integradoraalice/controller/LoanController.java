package com.example.integradoraalice.controller;

import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService servicio;

    public LoanController(LoanService servicio) {
        this.servicio = servicio;
    }
    // CREAR PRÉSTAMO
    @PostMapping
    public ResponseEntity<String> crearPrestamo(
            @RequestParam int idUsuario,
            @RequestParam int idLibro
    ) {
        return ResponseEntity.ok(
                servicio.crearPrestamo(idUsuario, idLibro)
        );
    }
    // DEVOLVER PRÉSTAMO
    @PostMapping("/{loanId}/return")
    public ResponseEntity<String> devolverPrestamo(
            @PathVariable("loanId") int idPrestamo
    ) {
        return ResponseEntity.ok(
                servicio.devolverLibro(idPrestamo)
        );
    }
    // OBTENER PRÉSTAMOS ACTIVOS
    @GetMapping("/active")
    public ResponseEntity<CatalogoSyngleLinkedList> obtenerPrestamosActivos() {
        return ResponseEntity.ok(
                servicio.obtenerPrestamosActivos()
        );
    }
    // OBTENER PRÉSTAMOS POR USUARIO
    @GetMapping("/user/{userId}")
    public ResponseEntity<CatalogoSyngleLinkedList> obtenerPrestamosPorUsuario(
            @PathVariable("userId") int idUsuario
    ) {
        return ResponseEntity.ok(
                servicio.obtenerPrestamosPorUsuario(idUsuario)
        );
    }
}
