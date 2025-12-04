import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] arr) {
        int x = arr.length;
        Boolean swapped = false;

        //Recorremos todos los elementos del arreglo
        for (int i = 0; i < x - 1; i++) {

            //Recorremos los elementos adyacentes -1 -i (Por los que ya fueron recorridos)
            for (int j = 0; j < x - 1 - i; j++) {
                //Pregunta si el elemento corriente es mayor que el siguiente
                if (arr[j] > arr[j + 1]) {
                    //Se realiza el intercambio
                    int temporal = arr[j];
                    arr[j] = arr[j + 1];//Pasa el elemento siguiente al actual
                    arr[j + 1] = temporal;
                    swapped = true;
                }
            }
            //La negacion sino hubo intercambio
            if (!swapped) break;
        }

        System.out.println("Arreglo ordenado");
        System.out.println(Arrays.toString(arr));
    }
}