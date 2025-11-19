import java.util.Arrays;

public class InsertionSort {

    public void sort (int[]arr){
        int n = arr.length;
        for (int i = 1; i < n; i ++){ //Comenzamos desde el segundo elemento
            int temp = arr [i]; //Este es el primer elemento de la parte desordenada ( comparativo)
            int j = i - 1;  //comenzamos desde el ultimo elemento de la parte ordenada(desde el ultimo)

            while(j >= 0 && arr[j] > temp){
                //vamos a recorrer a la derecha los elementos mayores al temporal
                arr[j+1] = arr[j];
                j--;
            }
            //Insertar el elemento en su posicion correcta
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}