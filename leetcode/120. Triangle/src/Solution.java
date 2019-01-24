import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int[] dp = new int[h];

        for (int i = 0; i < h; i++) {
            dp[i] = triangle.get(h - 1).get(i);
        }

        for (int i = h - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
//                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}