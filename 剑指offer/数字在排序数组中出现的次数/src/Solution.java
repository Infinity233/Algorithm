public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int i = lower_l(array, 0, array.length, k);
        int i1 = lower_r(array, 0, array.length, k);
        if(i == -1 || i1 == -1) {
            return 0;
        }
        return i1 - i + 1;
    }

    public int lower_l(int[] arr, int left, int right, int value) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                if ((mid - 1 < 0) || (arr[mid - 1] != value)) {
                    return mid;
                } else {
                    right = mid;
                    continue;
                }
            }
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return -1;
    }

    public int lower_r(int[] arr, int left, int right, int value) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                if ((mid + 1 >= right) || (arr[mid + 1] != value)) {
                    return mid;
                } else {
                    left = mid + 1;
                    continue;
                }
            }
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        System.out.println(s.GetNumberOfK(arr, k));
        System.out.println(s.lower_l(arr, 0, arr.length, -1));
        System.out.println(s.lower_r(arr, 0, arr.length, 999));
    }
}