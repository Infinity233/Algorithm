class Solution {
    public int mySqrt(int x) {

        if (x < 1) {
            return 0;
        } else if (x < 4) {
            return 1;
        }

        int l = 0;
        int r = x;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int t = x / m;
            if (m == t) {
                return m;
            } else if (m > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(2147395599));
    }
}