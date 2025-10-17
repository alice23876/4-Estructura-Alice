public class Main {
    public static void main(String[] args) {
        singlyLinkedList list = new singlyLinkedList();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printList();

        int valor = 2;
        int ocurrencias = list.countOccurrences(valor);
        System.out.println("Ocurrencias de \"" + valor + "\" = " + ocurrencias);
    }
}
