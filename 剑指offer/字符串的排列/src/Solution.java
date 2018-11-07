import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Solution {

    static int length;
    static int[] v;
    static char[] chs;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() <= 0) {
            return new ArrayList<>();
        }
        chs = str.toCharArray();
        length = chs.length;
        v = new int[length];

        ArrayList<String> res = new ArrayList<>(getNFactorial1(str.length()));
        find(1, "", res);
        LinkedHashSet<String> set = new LinkedHashSet<>(res);
        return new ArrayList<>(set);
    }

    private void find(int n, String now, ArrayList<String> list) {
        if (n > length) {
            list.add(now);
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (v[i] == 1) {
                continue;
            }

            v[i] = 1;
            find(n + 1, now + chs[i], list);
            v[i] = 0;
        }
    }

    private static int getNFactorial1(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> res = solution.Permutation("aa");

        System.out.println();
    }
}