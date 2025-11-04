public class Eliminadores{
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void separadorListas() {
        Eliminadores pares = new Eliminadores();
        Eliminadores impares = new Eliminadores();

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                pares.add(current.data);
            } else {
                impares.add(current.data);
            }
            current = current.next;
        }
        System.out.print("Original: ");
        this.printForward();

        System.out.print("Pares: ");
        pares.printForward();

        System.out.print("Impares: ");
        impares.printForward();
    }
}
