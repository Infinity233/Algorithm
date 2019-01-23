class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int h = obstacleGrid.length, w = obstacleGrid[0].length;
        int[][] dp = new int[h][w];

        for (int i = 0; i < h; i++) {
            if(obstacleGrid[i][0] == 1)
                break;
            dp[i][1] = 1;
        }

        for (int i = 0; i < w; i++) {
            if(obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if(obstacleGrid[i][j] == 1 || (obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1))
                    continue;

                if(obstacleGrid[i][j-1] == 1) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.uniquePathsWithObstacles(new int[][]{{0,0,1},{1,1,0},{0,0,0}});
    }
}