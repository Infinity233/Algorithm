import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.prefixesDivBy5(new int[]{0, 1, 1});
    }

    public List<Boolean> prefixesDivBy5(int[] A) {

        int a = 0, now = 0;
        List<Boolean> res = new ArrayList<>(A.length);
        for (int i : A) {
            now = ((now << 1) + i) % 5;
            if (now == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}