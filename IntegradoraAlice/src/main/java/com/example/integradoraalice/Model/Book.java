package com.example.integradoraalice.Model;

import com.example.integradoraalice.Structures.ArrayQueue;

public class Book {
    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    private boolean status = true;
    private ArrayQueue<Integer> waitList;

    public Book() {
        this.waitList = new ArrayQueue<>(50);
    }

    public Book(int id, String title, String author, int totalCopies, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.status = status;
        this.waitList = new ArrayQueue<>(50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayQueue<Integer> getWaitList() {
        return waitList;
    }

    public void setWaitList(ArrayQueue<Integer> waitList) {
        this.waitList = waitList;
    }

}
