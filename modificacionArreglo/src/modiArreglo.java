public class modiArreglo {
    public static void main(String[] args) {

        int[][] arrTest = {
                {1},
                {6, 3, 1},
                {1, 2, 3, 4},
                {0, 5, 3, 0},
                {2, 5, 9},
                {2, 4, 8, 9, 10}
        };
        int[][] nuevoArr = new int[arrTest.length][];
        for (int i = 0; i < arrTest.length; i++) {

            int[] filaOriginal = arrTest[i];
            int[] nuevaFila = new int[filaOriginal.length + 1];

            for (int j = 0; j < filaOriginal.length; j++) {
                nuevaFila[j] = filaOriginal[j];
            }
            int ultimoValor = filaOriginal[filaOriginal.length - 1];
            nuevaFila[nuevaFila.length - 1] = ultimoValor + 1;
            nuevoArr[i] = nuevaFila;
        }
        System.out.println("Nuevo arreglo modificado:");
        for (int i = 0; i < nuevoArr.length; i++) {
            for (int j = 0; j < nuevoArr[i].length; j++) {
                System.out.print(nuevoArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}