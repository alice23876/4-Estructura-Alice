public class SyngleLinkedList {
    private Node head;
    private int size;

    public SyngleLinkedList() {
        this.head = null;
        this.size = 0;
    }
    //Inserta el valor al final de la lista
    public void addLast(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    //Devuelve cuantos elementos hay en la lista
    public int size(){
        return size;
    }
    // Recorre la lista nodo por nodo hasta llegar a la posición index
    public int get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("indice invalido" + index);
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data);
            if (current.next != null){
                System.out.print(",");
            }
            current = current.next;
        }
        System.out.println();
    }
}
