//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
// La neta este código es bien sencillo, nomás hago una lista de materias y busco una, así sin tanta vuelta jaja

// Esta clase es para guardar las materias, agregar, buscar y mostrar, todo tranqui
class ListaMaterias {
    private ArrayList<String> materias;

    public ListaMaterias() {
        materias = new ArrayList<>();
    }

    // Aquí agrego una materia a la lista
    public void agregar(String materia) {
        materias.add(materia);
    }

    // Aquí checo si la materia está en la lista, usando .equals porque así se compara bien en Java
    public boolean contiene(String materia) {
        for (String m : materias) {
            if (m.equals(materia)) {
                return true;
            }
        }
        return false;
    }

    // Esto nomás imprime todas las materias, así de fácil
    public void imprimir() {
        System.out.print("Materias: [");
        for (int i = 0; i < materias.size(); i++) {
            System.out.print(materias.get(i));
            if (i < materias.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

public class Main {
    public static void main(String[] args) {
        // Aquí hago mi lista de materias, bien relax
        ListaMaterias lista = new ListaMaterias();
        lista.agregar("Matemáticas");
        lista.agregar("Física");
        lista.agregar("Química");
        lista.agregar("Historia");
        lista.agregar("Programación");

        // Imprimo las materias para que se vea bonito
        lista.imprimir();

        // Aquí pongo la materia que quiero buscar, la puedes cambiar si quieres
        String materiaBuscada = "Programación";
        System.out.println("Búsqueda: " + materiaBuscada);

        // Checo si está la materia y muestro el resultado, bien directo
        if (lista.contiene(materiaBuscada)) {
            System.out.println("Resultado: Materia encontrada");
        } else {
            System.out.println("Resultado: Materia no encontrada");
        }
    }
}