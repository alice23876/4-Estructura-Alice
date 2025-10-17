public class singlyLinkedList{
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);   // Creación de un nuevo Nodo
        if (head == null) {    // Verificación de lista vacía
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {    // Recorre hasta el último nodo
            current = current.next;
        }
        current.next = newNode; // Inserta el nuevo nodo al final
    }
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void remove(int data) {
        if (head == null) {  // Verifica si la lista está vacía
            return;
        }
        if (head.data == data) {  // Si el dato está en el primer nodo
            head = head.next;     // Elimina el primer nodo
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {  // Recorre hasta encontrarlo
            current = current.next;
        }
        if (current.next != null) {  // Si se encontró el dato
            current.next = current.next.next;  // Salta el nodo eliminado
        }
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println("null");
    }
    public int countOccurrences(int value) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                count++;
            }
            current = current.next;
        }

        return count;
    }
}
