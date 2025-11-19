public class Temperaturas {

    public int min(int[] arr) {
        return arr[0];
    }

    public int max(int[] arr) {
        return arr[arr.length - 1];
    }

    public int rango(int min, int max) {
        return max - min;
    }

    public int[] Altas(int[] arr) {
        int cantidad = arr.length < 3 ? arr.length : 3;

        int[] altas = new int[cantidad];

        int index = arr.length - cantidad;
        for (int i = 0; i < cantidad; i++) {
            altas[i] = arr[index + i];
        }

        return altas;
    }

    public int[] Bajas(int[] arr) {
        int cantidad = arr.length < 3 ? arr.length : 3;

        int[] bajas = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            bajas[i] = arr[i];
        }
        return bajas;
    }
}

