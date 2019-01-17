class Solution {
    public int pivotIndex(int[] nums) {

        int l = 0, sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if(l == sum-l-nums[i])
                return i;
            l += nums[i];
        }
        return -1;
    }
}