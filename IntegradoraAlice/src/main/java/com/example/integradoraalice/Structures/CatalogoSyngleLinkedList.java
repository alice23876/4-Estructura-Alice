package com.example.integradoraalice.Structures;

//Esta clase majera el catalogo de libros, lista de usuarios, historial de presatmos

public class CatalogoSyngleLinkedList <T> {
    public Node head;

    public void add(Object data) {
        Node newNode = new Node(data);//Creación de un nuevo nodo
        if (head == null) {//Verficación de lista vacia
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {//Recorrido de nodos, hasta encontrar el ultimo
            curr = curr.next;
        }
        curr.next = newNode;//Insertar nuevo nodo al final de la lista
    }

    public Boolean contains(Object data){ //Iniciara el metodo de búsqueda.
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;

        }
        return false;
    }
    public Object get(int index) {
        int i = 0;
        Node curr = head;
        while (curr != null) {
            if (i == index) return curr.data;
            i++;
            curr = curr.next;
        }
        return null;
    }

    public boolean remove(Object data) {
        if (head == null) return false;//Pregunta si la lista esta vacia

        if (head.data.equals(data)) {//Valida que el dato este en el head
            head = head.next;//Elimina el primer nodo
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data.equals(data)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}