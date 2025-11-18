public class ParesImpares {
    public int[] Pares(int[] arr) {

        int contador = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                contador++;
            }
        }

        int[] pares = new int[contador];
        int index = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                pares[index] = n;
                index++;
            }
        }
        return pares;
    }
    public int[] Impares(int[] arr) {
        int contador = 0;
        for (int n : arr) {
            if (n % 2 != 0) {
                contador++;
            }
        }
        int[] impares = new int[contador];
        int index = 0;
        for (int n : arr) {
            if (n % 2 != 0) {
                impares[index] = n;
                index++;
            }
        }
        return impares;
    }
}

