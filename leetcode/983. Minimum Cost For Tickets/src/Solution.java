class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        boolean[] travelDays = new boolean[366];
        int[] dp = new int[366];
        for (int day : days) {
            travelDays[day] = true;
        }

        dp[0] = 0;
        int min;
        for (int i = 1; i < 366; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            min = dp[i - 1] + costs[0];
            min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);

            dp[i] = min;
        }

        return dp[365];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}