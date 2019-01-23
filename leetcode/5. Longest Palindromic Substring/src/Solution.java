class Solution {
    public String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        String ss = sb.toString();

        int[] p = new int[ss.length()];
        int mx = 0, ans = 0, ps = 0, resCenter = 0;

        for (int i = 1; i < ss.length(); i++) {
            if (mx > i) {
                p[i] = Math.min(p[2 * ps - i], mx - i);
            } else {
                p[i] = 1;
            }

            while (i - p[i] >= 0 && i + p[i] < ss.length() && ss.charAt(i - p[i]) == ss.charAt(i + p[i])) {
                ++p[i];
            }

            if (p[i] + i - 1 > mx) {
                mx = p[i] + i - 1;
                ps = i;
            }
            if (ans < p[i]) {
                ans = p[i];
                resCenter = i;
            }
        }

        int start = (resCenter - ans) / 2;
        return s.substring(start, start + ans -1);
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.longestPalindrome("123456"));
    }
}