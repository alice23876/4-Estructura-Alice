public class BinarySearchTree {
    Node root; // raiz de nuestro arbol

    public void insert(int value){
        root = insertRecursive(root, value);
    }
    private Node insertRecursive(Node current, int value){

        // caso base, cuando current sea null, en este punto vamos  acrear el nodo
        if (current ==  null) {
            return new Node(value);
        }

        // si el valor a insertar es menor al valor de current
        // entonces vamos a crear el np de lado izquierdo
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        }else if(value > current.value){
            current.right = insertRecursive(current.right, value);
        }

        return current; // null solo en lo que lo teminamso
    }

    public void printInOrder(){
        System.out.println("print in order");
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node current){
        if (current != null) {
            //recorrido del lado izquierdo
            printInOrderRecursive(current.left);
            System.out.println(current.value + " ");

            printInOrderRecursive(current.right);
        }
    }
}

