import java.util.Arrays;

public class Solution {
    public String ReverseSentence(String str) {

        if (str == null || str.length() < 1) {
            return "";
        }
        char[] chs = str.toCharArray();

        reverse(chs, 0, chs.length - 1);

        int left, right;
        left = right = 0;

        while (left < chs.length) {

            while (left < chs.length && chs[left] == ' ') {

                left++;
                right++;
            }

            while (right < chs.length && chs[right] != ' ') {
                right++;
            }

            reverse(chs, left, right - 1);
            left = right;
        }
        return String.valueOf(chs);
    }

    private void reverse(char[] str, int begin, int end) {

        char t;

        while (begin < end) {
            t = str[begin];
            str[begin] = str[end];
            str[end] = t;
            ++begin;
            --end;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] chs = {'a', 'b', 'c', 'd'};
        System.out.println(s.ReverseSentence(" "));
    }
}