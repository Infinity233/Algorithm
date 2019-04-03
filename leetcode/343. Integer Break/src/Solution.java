class Solution {
    public int integerBreak(int n) {

        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int time3 = n / 3;
        if ((n - time3 * 3) == 1) {
            time3--;
        }

        int time2 = (n - time3 * 3) / 2;
        return (int) Math.pow(3, time3) * (int) Math.pow(2, time2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.integerBreak(10);
    }
}