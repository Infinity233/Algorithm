import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static List<Integer> list;
    private static Integer t;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>(candidates.length * 2);
        t = target;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        sol(candidates, 0, 0, res);
        return res;
    }

    public void sol(int[] a, int sum, int now, List<List<Integer>> res) {
        if (sum == t) {
            res.add(new ArrayList<>(list));
        }

        if (sum > t) {
            return;
        }

        for (int i = now; i < a.length; ++i) {
            if (i > now && a[i] == a[i - 1]) {
                continue;
            }
            list.add(a[i]);
            sol(a, sum + a[i], i + 1, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> list = s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list);
    }
}