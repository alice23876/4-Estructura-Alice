import java.util.Arrays;

public class SelectionClass {
    public void sort(Estudiante[] estudiantes) {
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getCalificacion() < estudiantes[minIndex].getCalificacion()) {
                    minIndex = j;
                }
            }
            Estudiante temp = estudiantes[minIndex];
            estudiantes[minIndex] = estudiantes[i];
            estudiantes[i] = temp;
        }
    }
}
