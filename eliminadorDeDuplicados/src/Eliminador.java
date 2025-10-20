public class Eliminador {
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
            newNode.prev = current;
        }

        public void remove() {
            Node current = head;
            while (current != null) {
                Node actual = current.next;
                while (actual != null) {
                    if (actual.data == current.data) {
                        if (actual.prev != null) {
                            actual.prev.next = actual.next;
                        }
                        if (actual.next != null) {
                            actual.next.prev = actual.prev;
                        }
                    }
                    actual = actual.next;
                }
                current = current.next;
            }
        }

        public void printForward() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
}