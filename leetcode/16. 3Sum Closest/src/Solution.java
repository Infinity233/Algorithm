import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        int len2 = nums.length - 2;
        int len1 = nums.length - 1;
        int l, r;
        Arrays.sort(nums);
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > len2) {
                break;
            }

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum = target - nums[i];
            l = i + 1;
            r = len1;

            while (l < r) {
                int t = nums[l] + nums[r];
                if (t == sum) {
                    return target;
                } else if (t < sum) {
                    System.out.println((res - target) + "," + Math.abs(res - target));
                    if (Math.abs(sum - t) < Math.abs(target - res)) {
                        res = t + nums[i];
                    }
                    while (l < r && nums[l++] == nums[l]) {
                    }
                } else {
                    if (Math.abs(sum - t) < Math.abs(target - res)) {
                        res = t + nums[i];
                    }
                    while (l < r && nums[r--] == nums[r]) {
                    }
                }
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }
}
