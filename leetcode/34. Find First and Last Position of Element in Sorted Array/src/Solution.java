import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length - 1, m = -1, flag = 0;

        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                flag = 1;
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int[] res = {-1, -1};
        if (flag == 1) {
            l = r = m;
            while (true) {
                if (l > 0 && nums[l - 1] == target) {
                    l--;
                } else {
                    break;
                }
            }
            while (true) {
                if (r < nums.length - 1 && nums[r + 1] == target) {
                    ++r;
                } else {
                    break;
                }
            }
            res[0] = l;
            res[1] = r;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] x = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(x));
    }
}