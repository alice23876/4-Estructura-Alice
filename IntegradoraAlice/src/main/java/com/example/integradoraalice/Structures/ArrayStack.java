package com.example.integradoraalice.Structures;

public class ArrayStack<T> {
    private Object[] data;
    private int top;
    private static final int INITIAL_CAPACITY = 20;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    // Insertar (push)
    public void push(T element) {
        expandCapacity();
        data[top++] = element;
    }
    // Remover (pop) - alias: pull, poll
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }

        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    public T pull() {
        return pop();
    }

    public T poll() {
        return pop();
    }

    // Ver el top sin sacar
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return (T) data[top - 1];
    }

    // Auxiliares
    public void clear() {
        for (int i = 0; i < top; i++) {
            data[i] = null;
        }
        top = 0;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    // Expansión automática
    private void expandCapacity() {
        if (top < data.length)
            return;

        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < top; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    // Print para depuración
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0)
                sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
