class Solution {
    public int rob(int[] nums) {

        int res = 0;

        if (nums.length == 0) {
            return res;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0];

        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        res = dp[nums.length - 2];

        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                dp[i] = Math.max(nums[1], nums[2]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        res = Math.max(res, dp[nums.length - 1]);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
}