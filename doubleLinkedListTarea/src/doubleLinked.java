public class doubleLinked {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }
    public void printList() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void remove(int value) {
        if (head == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }

        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Este valor no se encuentra");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        else {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }

        System.out.println("Nodo " + value + " eliminado");
    }
}
