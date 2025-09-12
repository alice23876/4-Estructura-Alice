import java.util.ArrayList;
import java.util.List;

class Worker {
    int id;
    String nombre;
    double sueldo;
    public Worker(int id, String nombre, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "id =" + id + ", nombre =" + nombre + ", sueldo =" + sueldo ;
    }
}

public class Main {
    public static void main(String[] args) {
        // Lista worker
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(1, "Marlen", 500));
        workers.add(new Worker(2, "Sundown", 200));
        workers.add(new Worker(3, "Emilio", 1760));
        workers.add(new Worker(4, "Campos", 3500));
        workers.add(new Worker(5, "Toti", 1500));
        workers.add(new Worker(6, "Alice", 900));

        // Lista normal
        System.out.println("Lista original:");
        for (Worker w : workers) {
            System.out.println(w);
        }

        // Calcular promedio
        double suma = 0;
        for (Worker w : workers) {
            suma += w.sueldo;
        }
        double promedio = suma / workers.size();
        System.out.println("\n Promedio de sueldos: " + promedio);

        // Eliminacion de sueldos
        workers.removeIf(w -> w.sueldo < 1000);

        // nueva lista
        System.out.println("Nueva lista mayores a 1000: ");
        for (Worker w : workers) {
            System.out.println(w);
        }
    }
}