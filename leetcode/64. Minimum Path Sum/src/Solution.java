class Solution {
    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int h = grid.length, w = grid[0].length;
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < w; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[h - 1][w - 1];
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }
}