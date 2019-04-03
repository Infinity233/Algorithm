import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLongestChain(new int[][]{{3, 4}, {1, 2}, {2, 3}}));
    }

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[0]));
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }
}