import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {

        int l, r, m;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                if (nums[r] < nums[m] && nums[l] > target) {
                    l = m + 1;
                } else if (m > 0 && nums[m - 1] <= nums[m]) {
                    r = m - 1;
                } else {
                    return -1;
                }
            } else if (nums[m] < target) {
                if (nums[l] > nums[m] && nums[r] < target) {
                    r = m - 1;
                }
                else if (m < nums.length - 1 && nums[m + 1] >= nums[m]) {
                    l = m + 1;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new Solution().search(new int[]{5, 1, 3}, 5));

    }
}
