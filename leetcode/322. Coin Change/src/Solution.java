class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int money : coins) {

                if (i - money >= 0 && dp[i - money] + 1 < min && dp[i - money] != -1) {
                    min = dp[i - money] + 1;
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[amount];
    }
}