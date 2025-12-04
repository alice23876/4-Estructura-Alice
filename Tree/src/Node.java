public class Node {
    int value;
    Node left;
    Node right;

    //FABRICA DE HOJAS
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;  //como es nuevo nodo
    }
}
