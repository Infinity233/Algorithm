class Solution {
    public int longestValidParentheses(String s) {

        int l, r, res, len;
        l = r = res = 0;
        len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                ++l;
            } else {
                ++r;
            }

            if (l == r) {
                res = Math.max(res, l * 2);
            } else if (l < r) {
                l = r = 0;
            }
        }
        l = r = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                ++l;
            } else {
                ++r;
            }

            if (l == r) {
                res = Math.max(res, l * 2);
            } else if (l > r) {
                l = r = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}