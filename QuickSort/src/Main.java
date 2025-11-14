import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort sorting = new QuickSort();

        int[] arr = {9,7,5,11,12,2,14,3,10,6};
        System.out.println("Arreglo antes de ordenar:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Arreglo despues de ordenar:");
        sorting.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}