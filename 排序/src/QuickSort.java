public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partSort(arr, left, right);
        quickSort(arr, left, index);
        quickSort(arr, index + 1, right);
    }

    private static int partSort(int[] arr, int left, int right) {
        int key = arr[left];
        int i = left + 1, j = right - 1, t;

        while (i < j) {

            while (i < j && arr[j] >= key) {
                --j;
            }

            while (i < j && arr[i] <= key) {
                ++i;
            }

            swap(arr, i, j);
        }
        if (arr[left] > arr[j]) {
            swap(arr, left, j);
        }

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
