public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int isFu = 0;
        if (str.charAt(0) == '-') {
            isFu = 1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        int res = 0;
        for (int i = 0; i < str.length(); i++) {

            if (!isNum(str.charAt(i))) {
                return 0;
            }

            res *= 10;
            res += str.charAt(i) - '0';
        }
        if (isFu == 1) {
            res = -res;
        }
        return res;
    }

    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.StrToInt("+2147483647"));
    }
}