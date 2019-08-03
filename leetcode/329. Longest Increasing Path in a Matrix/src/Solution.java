class Solution {

    int[][] dp, a, flag;
    int[][] fang = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n, m;

    public int longestIncreasingPath(int[][] matrix) {
        a = matrix;
        if (a.length == 0) {
            return 0;
        }

        n = a.length;
        m = a[0].length;
        dp = new int[n][m];
        flag = new int[n][m];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = search(i, j);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private int search(int x, int y) {

        if (flag[x][y] != 0) {
            return dp[x][y];
        }

        int tx, ty, ans = 1;
        for (int i = 0; i < 4; i++) {
            tx = x + fang[i][0];
            ty = y + fang[i][1];

            if (judge(tx, ty)) {
                if (a[tx][ty] < a[x][y]) {
                    ans = Math.max(ans, search(tx, ty) + 1);
                }
            }
        }
        flag[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }

    private boolean judge(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestIncreasingPath(new int[][]{
                {3,4,5},
                {3,2,6},
                {2,2,1}
        }));
    }
}