import java.util.ArrayDeque;

class Solution {

    public boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        boolean[] ok = new boolean[nums.length];
        ok[nums.length - 1] = true;
        int last = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (i + nums[i] >= last) {
                last = i;
                ok[i] = true;
            }
        }

        return ok[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}