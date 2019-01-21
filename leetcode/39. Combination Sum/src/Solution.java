import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static int[] nums;
    private static int tar;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        tar = target;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        sol(res, new ArrayList<>(), target, 0);
        return res;
    }

    public void sol(List<List<Integer>> res, List<Integer> temp, Integer target, Integer start) {

        for (int i = start; i < nums.length; i++) {

            if (target > 0) {

                temp.add(nums[i]);
                sol(res, temp, target - nums[i], i);
                if (temp.size() != 0) {
                    temp.remove(temp.size() - 1);
                }
            } else if (target < 0) {
                return;
            } else {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println();
    }
}