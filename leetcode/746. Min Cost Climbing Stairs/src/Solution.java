class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0 || len == 1) {
            return 0;
        } else if (len == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}