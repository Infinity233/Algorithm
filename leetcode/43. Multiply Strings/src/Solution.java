class Solution {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.length() <= 0 || num2.length() <= 0) {
            return "";
        }

        int len = num1.length() + num2.length();
        StringBuilder res = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            res.append('0');
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int add = 0;

            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res.charAt(i + j + 1) + add + mul % 10 - '0';
                res.setCharAt(i + j + 1, (char) (sum % 10 + '0'));
                add = mul / 10 + sum / 10;
            }
            res.setCharAt(i, (char) (add + '0'));
        }

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                return res.substring(i);
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("2", "3"));
    }
}