public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.LastRemaining_Solution(5, 2));

    }
}
