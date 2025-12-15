package com.example.integradoraalice.Structures;

// maneja la lista de espera de los libros.Los usuarios se forman y se atienden en el orden en que llegan, usando el principio FIFO,
public class ArrayQueue<T> {

    private Object[] data;
    private int front; // índice del frente
    private int rear;  // índice del siguiente espacio de inserción
    private int size;  // número de elementos
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Insertar - varios alias (offer, add, enqueue, push)
    public void offer(T element) {
        expandCapacity();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    public void add(T element) {
        offer(element);
    }

    public void enqueue(T element) {
        offer(element);
    }

    public void push(T element) {
        offer(element);
    }

    // Remover - varios alias (poll, pull, dequeue)
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }

        T result = (T) data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size--;
        return result;
    }

    public T pull() {
        return poll();
    }

    public T dequeue() {
        return poll();
    }

    // Ver el primero sin sacarlo
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }
        return (T) data[front];
    }

    // Métodos auxiliares
    private void expandCapacity() {
        if (size < data.length)
            return;

        Object[] newArr = new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }

        data = newArr;
        front = 0;
        rear = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
