import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String reverseWords(String s) {
        if (s.length() < 1) {
            return "";
        }
        s = s.trim();
        String[] ss = s.split(" ");
        List<String> strs = Arrays.stream(ss)
                .filter(str -> str.length() > 0)
                .map(str -> " " + str)
                .collect(Collectors.toList());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.insert(0, str);
        }
        System.out.println(res.length());
        if (res.length() < 1) {
            return "";
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords(" "));
        System.out.println(" ".substring(1));
    }
}