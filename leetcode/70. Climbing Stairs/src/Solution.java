class Solution {
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int i = 1, j = 2, t;

        for (int k = 3; k <= n; k++) {

            t = i + j;
            i = j;
            j = t;
        }

        return j;
    }
}