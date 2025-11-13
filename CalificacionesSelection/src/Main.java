public class Main {
    public static void main(String[] args) {
        Estudiante[] listaEstudiantes = {
                new Estudiante("Alice", 8),
                new Estudiante("Marlen", 9),
                new Estudiante("Kevin", 7),
                new Estudiante("Luz", 10),
                new Estudiante("Luis", 6)
        };

        System.out.println("Lista de estudiantes antes:");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante);
        }

        SelectionClass selection = new SelectionClass();
        selection.sort(listaEstudiantes);

        System.out.println("Lista de estudiantes ordenada:");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante);
        }
    }
}