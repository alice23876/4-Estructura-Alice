package com.example.integradoraalice.service;

import com.example.integradoraalice.Model.HistoryAction;
import com.example.integradoraalice.Structures.ArrayStack;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private ArrayStack<HistoryAction> historial = new ArrayStack<>();

    // Registrar cualquier acción
    public void registrar(String accion, String detalle) {
        historial.push(new HistoryAction(accion, detalle));
    }

    // Undo (saca la última acción)
    public HistoryAction undo() {
        return historial.pop();
    }

    // Ver la última sin quitarla
    public HistoryAction ultimaAccion() {
        return historial.peek();
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }
}
