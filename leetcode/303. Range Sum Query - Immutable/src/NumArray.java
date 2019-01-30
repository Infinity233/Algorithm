class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        if (nums!= null && nums.length > 0) {
            sum = new int[nums.length];
            int t = nums[0];
            sum[0] = t;
            for (int i = 1; i < nums.length; i++) {
                t += nums[i];
                sum[i] = t;
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }

    public static void main(String[] args) {
        NumArray s = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(s.sumRange(0, 2));
        System.out.println(s.sumRange(2, 5));
        System.out.println(s.sumRange(0, 5));

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */