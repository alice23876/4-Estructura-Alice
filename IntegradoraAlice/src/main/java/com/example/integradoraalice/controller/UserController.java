package com.example.integradoraalice.controller;

import com.example.integradoraalice.Structures.CatalogoSyngleLinkedList;
import com.example.integradoraalice.dto.UserRequest;
import com.example.integradoraalice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //Inicializar el servicio
    private final UserService servicio;

    public UserController(UserService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody UserRequest solicitud) {
        return ResponseEntity.ok(servicio.agregarUsuario(solicitud));
    }

    @GetMapping
    public ResponseEntity<CatalogoSyngleLinkedList> encontrarTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> encontrarPorId(@PathVariable int id) {
        UserRequest encontrado = servicio.buscarPorId(id);
        if (encontrado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(encontrado);
    }
}
