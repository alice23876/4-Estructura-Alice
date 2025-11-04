public class Main {
    public static void main(String[] args) {
        ArrayQueue<Customer> queue = new ArrayQueue<>();

        queue.enqueue(new Customer(1, "Alice"));
        queue.enqueue(new Customer(2, "Luis"));
        queue.enqueue(new Customer(3, "Sundown"));
        queue.enqueue(new Customer(4, "Emilio"));
        queue.enqueue(new Customer(5, "Marlen"));
        queue.enqueue(new Customer(6, "Abraham"));


        System.out.println("Antes de invertir:");
        System.out.println(queue);

        int before = queue.getSize();
        queue.reverse();

        System.out.println("Después de invertir:");
        System.out.println(queue);

        int after = queue.getSize();

        System.out.println("Elementos antes = " + before + ", elementos después = " + after);
    }
}
