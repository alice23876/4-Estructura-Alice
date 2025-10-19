public class Main {
    public static void main(String[] args) {
        doubleLinked lista = new doubleLinked();

        lista.add(12);
        lista.add(46);
        lista.add(30);
        lista.add(53);
        lista.add(23);

        System.out.println("-----Lista original-----");
        lista.printList();

        lista.remove(12); // Inicio
        lista.remove(30); // Medio
        lista.remove(23); // Final

        System.out.println("------Lista nueva------");
        lista.printList();
    }
}
