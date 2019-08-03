import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    static List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {

        if(nums.length<1) {
            return new ArrayList<>();
        }

        int len = 1;
        for (int i = 2; i <= nums.length; i++) {
            len*=i;
        }
        res = new ArrayList<>(len);

        qvan(nums, 0);
        return res;
     }

    private void qvan(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            List<Integer> t = new ArrayList<>(nums.length);
            for (int num : nums) {
                t.add(num);
            }
            res.add(t);
        }

        for (int i = pos; i < nums.length ; i++) {

            swap(nums, i, pos);
            qvan(nums, pos + 1);
            swap(nums, i, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.qvan(new int[]{1,2,3}, 0);
    }
}