import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int l = 0, r = array.length - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (array[m] > array[l]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }
}