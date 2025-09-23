import java.util.ArrayDeque;
import java.util.Queue;

// Simulacion de un banco que atiende clientes
public class Main {
    public static void main(String[] args) {

        // Creamos la cola de clientes del banco
        Queue<Cliente> queue = new ArrayDeque<>();
        
        // Creamos 3 clientes con sus nombres
        Cliente c1 = new Cliente(1, "Carlos");
        Cliente c2 = new Cliente(2, "Maria");
        Cliente c3 = new Cliente(3, "Jose");
        
        // A cada cliente le agregamos 2 documentos
        c1.agregaDoc("Doc1");
        c1.agregaDoc("Doc2");
        
        c2.agregaDoc("Doc1");
        c2.agregaDoc("Doc2");
        
        c3.agregaDoc("Doc1");
        c3.agregaDoc("Doc2");

        // Agregamos los clientes a la cola del banco
        queue.offer(c1);
        queue.offer(c2);
        queue.offer(c3);

        // Atendemos a cada cliente
        while (!queue.isEmpty()) {
            Cliente clienteActual = queue.poll();
            clienteActual.atender();
            
            // Mostramos quienes quedan en la cola
            System.out.print("Cola restante: [");
            boolean primero = true;
            for (Cliente cliente : queue) {
                if (!primero) {
                    System.out.print(", ");
                }
                System.out.print(cliente.name);
                primero = false;
            }
            System.out.println("]");
            System.out.println(); // Linea en blanco para separar
        }
    }
}