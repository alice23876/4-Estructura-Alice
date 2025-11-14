import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BubbleSort sorting = new BubbleSort();

        int arr[] = {4, 2, 9, 2, 4, 7, 1};

        System.out.println("Arreglo antes de ordenar:");
        System.out.println(Arrays.toString(arr));
        sorting.sort(arr);
        System.out.println("Arreglo ordenado sin duplicados:");
        int[] sinDuplicados = sorting.eliminar(arr);
        System.out.println(Arrays.toString(sinDuplicados));
    }
}
