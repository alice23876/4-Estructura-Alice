import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temporal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporal;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Arreglo ordenado");
        System.out.println(Arrays.toString(arr));
    }
    public int[] eliminar(int[] arr) {

        ArrayList<Integer> lista = new ArrayList<>();

        for (int n : arr) {
            if (!lista.contains(n)) {
                lista.add(n);
            }
        }
        int[] resultado = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i);
        }

        return resultado;
    }
}
