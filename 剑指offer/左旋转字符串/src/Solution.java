public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1) {
            return "";
        }
        n %= str.length();
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.LeftRotateString("", 6));
    }
}