public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int sum = array[0];
        int res = sum;
        for (int i = 1; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            res = Math.max(sum, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(i);
    }
}