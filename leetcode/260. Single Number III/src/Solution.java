import java.util.Arrays;

class Solution {
    public int[] singleNumber(int[] nums) {

        int s = 0;
        for (int i : nums) {
            s ^= i;
        }

        int bitFlag = s & -s;
        int l = 0, r = 0;

        for (int num : nums) {

            if ((num & bitFlag) != 0) {
                l ^= num;
            } else {
                r ^= num;
            }
        }
        return new int[]{l, r};
    }
}