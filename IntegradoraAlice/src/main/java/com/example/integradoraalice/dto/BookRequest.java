package com.example.integradoraalice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
}