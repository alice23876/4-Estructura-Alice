

public class SinglyLinkedList {
    Node head;

    public void add(int data){
            Node newNode = new Node(data);   //Creación de un nuevo Nodo
            if (head == null){    //verificacion de lista vacía
                head = newNode;
                return;
            }
            Node current= head;
            while (current.next != null){    //Recorrido de los nodos, hasta encontrar el ultimo
                current = current.next;
            }
            current.next = newNode; // Aqui se inserta un nuevo nodo aL FINAL de la lista
    }

    //== para comparar datos primitivos
    //
    public boolean contains(int data){
        Node current = head;
        while (current != null){
            if (current.data == data){
                return  true;
            }

            current = current.next;
        }
        return false;
    }
    public void remove(int data) {
        if (head == null) {  //Pregunta si la lista esta vacia
            return;
        }
        if (head.data == data) {  //valida que el dato este en el head
            head = head.next; // Elimina el primer nodo
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {  //Recorre hasta encontrar
            current = current.next;
        }
        current.next = current.next.next;//Asignamos el nodo corriente al siguiente
    }
    public  void printList(){
        Node current=head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }
}
