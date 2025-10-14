public class arrBi {

    public static void main(String[] args) {
        int[][] arrTest = {
                {1},
                {6, 3, 1},
                {1, 2, 3, 4},
                {0, 5, 3, 0},
                {2, 5, 9},
                {2, 4, 8, 9, 10}
        };

        System.out.println("{");
        for (int i = 0; i < arrTest.length; i++) {

            int tam = arrTest[i].length;
            int ultimo = arrTest[i][tam - 1];
            int primero = arrTest[i][0];
            int agregado;

            if (tam % 2 == 0) {
                agregado = primero + ultimo;
            } else {
                agregado = 0;
            }

            System.out.print("  {");
            for (int j = 0; j < tam; j++) {
                System.out.print(arrTest[i][j] + ",");
            }
            System.out.print(agregado + "}");
            System.out.print(",");
            System.out.println();
        }
        System.out.println("}");
    }
}
