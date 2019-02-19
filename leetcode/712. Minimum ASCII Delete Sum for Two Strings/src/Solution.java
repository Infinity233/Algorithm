class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i + 1] = dp[0][i] + s2.charAt(i);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        s1 = "." + s1;
        s2 = "." + s2;
        for (int i = 1; i < dp.length; ++i) {
            boolean flag = false;
            for (int j = 1; j < dp[0].length; ++j) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    if (flag) {
                        dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j), dp[i-1][j-1]);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                        flag = true;
                    }
                } else {

                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + s2.charAt(j));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + s1.charAt(i));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + s1.charAt(i) + s2.charAt(j));
                }
            }
        }

        return dp[s1.length() - 1][s2.length() - 1];
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.minimumDeleteSum("djoqzmzxe", "onydroiizrlggfh"));
        System.out.println(s.minimumDeleteSum("djoqz", "onydroiiz"));
        System.out.println(s.minimumDeleteSum("doz", "odoz"));
        // doz
        System.out.println('j' + 'q' + 'm' + 'z' + 'x' + 'e' + 'o' + 'n' + 'y'
                + 'r' + 'i' + 'i' + 'r' + 'l' + 'g' + 'g' + 'f' + 'h');
        System.out.println('o'+0);
    }
}