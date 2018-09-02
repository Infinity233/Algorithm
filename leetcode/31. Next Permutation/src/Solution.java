import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int length_1 = nums.length - 1;
        int k = -1, t;
        for (int i = 0; i < length_1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }

        if (k != -1) {
            int min = k + 1;
            for (int i = k + 1; i < nums.length; ++i) {
                if (nums[i] > nums[k]) {
                    if (nums[i] <= nums[min]) {
                        min = i;
                    }
                }
            }

            t = nums[k];
            nums[k] = nums[min];
            nums[min] = t;
        }

        int l, r;
        l = k + 1;
        r = nums.length - 1;
        while (l < r) {
            t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            ++l;
            --r;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{1, 3, 3});
    }
}