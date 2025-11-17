public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temporal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporal;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
