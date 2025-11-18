import java.util.Arrays;
public class SelectionSort {

    public void sort(int[]arr) {
        int n = arr.length; //extraer el numero del arreglo
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; //Seleccionamos el primero como el menor
            for (int j = i + 1; j < arr.length; j++) { //la parte que no ha sido ordenada
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; //indice menor dentro de la parte no ordenada
                }
            }
            //Intercambio de posicion (pasa el menor a la posicion indicada de la parte ordenada del metodo
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
