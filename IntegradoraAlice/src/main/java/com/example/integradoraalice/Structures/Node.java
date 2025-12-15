package com.example.integradoraalice.Structures;

public class Node<T> {
    public T data;  //contenido de mi nodo
    public Node<T> next; //referencia al siguiente para syngle

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
