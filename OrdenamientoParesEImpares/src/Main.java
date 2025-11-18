import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos números deseas ingresar al arreglo?: ");
        int n = sc.nextInt();

        int[] sort = new int[n];

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            sort[i] = sc.nextInt();
        }

        ParesImpares x = new ParesImpares();
        int[] pares = x.Pares(sort);
        int[] impares = x.Impares(sort);

        SelectionSort sorting = new SelectionSort();
        sorting.sort(pares);
        sorting.sort(impares);

        System.out.println("Ordenado por pares:");
        System.out.println(Arrays.toString(pares));
        System.out.println("Ordenado por impares:");
        System.out.println(Arrays.toString(impares));
        System.out.println("Original");
        System.out.println(Arrays.toString(sort));
    }
}
