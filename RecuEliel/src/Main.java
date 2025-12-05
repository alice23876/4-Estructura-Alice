public class Main {
    public static int[] toArray(SyngleLinkedList list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length; //tamaño del arreglo
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        SyngleLinkedList temperaturas = new SyngleLinkedList();
        //28, 31, 26, 30, 29
        temperaturas.addLast(28);
        temperaturas.addLast(31);
        temperaturas.addLast(26);
        temperaturas.addLast(30);
        temperaturas.addLast(29);

        System.out.println("Lista sin ordenar:");
        temperaturas.printList();

        int[] arrTemporal = toArray(temperaturas);
        BubbleSort(arrTemporal);

        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < arrTemporal.length; i++) {
            System.out.print(arrTemporal[i]);
            if (i < arrTemporal.length - 1) {
                System.out.print(",");
            }
        }
    }
}
