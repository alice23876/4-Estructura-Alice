import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BubbleSort sorting = new BubbleSort();

        System.out.print("¿Cuántos números tendrá el arreglo? ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Ingresa los números:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        sorting.sort(arr);
        int min = arr[0];
        int max = arr[arr.length - 1];
        int diferencia = max - min;

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
        System.out.println("Valor mínimo: " + min);
        System.out.println("Valor máximo: " + max);
        System.out.println("Diferencia: " + diferencia);
    }
}
