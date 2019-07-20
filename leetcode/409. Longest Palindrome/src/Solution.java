import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestPalindrome(String s) {

        char[] chs = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int result = 0;
        for (char ch : chs) {
            if (set.contains(ch)) {
                set.remove(ch);
                result++;
            } else {
                set.add(ch);
            }
        }
        result *= 2;
        return set.isEmpty() ? result : result + 1;
    }
}