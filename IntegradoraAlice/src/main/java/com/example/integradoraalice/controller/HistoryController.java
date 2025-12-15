package com.example.integradoraalice.controller;

import com.example.integradoraalice.Model.HistoryAction;
import com.example.integradoraalice.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    private final HistoryService historyService;
     //Inicializamo el servicio
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/undo")
    public ResponseEntity<HistoryAction> undo() {

        HistoryAction action = historyService.undo();

        if (action == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(action);
    }
}

