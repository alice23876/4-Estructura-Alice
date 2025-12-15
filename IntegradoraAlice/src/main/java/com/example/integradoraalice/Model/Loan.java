package com.example.integradoraalice.Model;

public class Loan {
    private int id;
    private int userId;
    private int bookId;
    private String status;

    public Loan() {
    }

    public Loan(int id, int userId, int bookId, String status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
