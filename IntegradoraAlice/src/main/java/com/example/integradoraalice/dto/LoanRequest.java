package com.example.integradoraalice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private int id;
    private int userId;
    private int bookId;
    private String status;
}
