import java.util.Arrays;

public class Solution {

    public static final Integer mod = 1000000007;
    private Integer res = 0;

    public int InversePairs(int[] array) {
        res = 0;
        sort(array);
        return res;
    }

    private void sort(int[] arr) {
        sort(arr, 0, arr.length, new int[arr.length]);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {

        if (left + 1 < right) {
            int mid = (right + left) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i, j, k;
        i = left;
        j = mid;
        k = left;
        int remain = mid - left;
        while (i < mid && j < right) {

            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
                remain--;
            } else {
                temp[k++] = arr[j++];
                res = (res + remain) % mod;
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < right) {
            temp[k++] = arr[j++];
        }

        k = left;

        while (k < right) {
            arr[k] = temp[k];
            ++k;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }
}