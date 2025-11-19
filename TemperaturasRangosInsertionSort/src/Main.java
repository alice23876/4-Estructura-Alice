import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        InsertionSort insertion = new InsertionSort();
        int[] arr = {25, 18, 30, 22, 19, 16, 89};

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Arreglo ordenado:");
        insertion.sort(arr);

        Temperaturas tempe = new Temperaturas();
        int min = tempe.min(arr);
        int max = tempe.max(arr);
        int rango = tempe.rango(min, max);
        int[] altas = tempe.Altas(arr);
        int[] bajas = tempe.Bajas(arr);

        System.out.println("Temperatura mínima: " + min);
        System.out.println("Temperatura máxima: " + max);
        System.out.println("Rango: " + rango);

        System.out.println("Temperaturas altas:");
        System.out.println(Arrays.toString(altas));
        System.out.println("Temperaturas bajas:");
        System.out.println(Arrays.toString(bajas));
    }
}