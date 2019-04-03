class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortColors(new int[]{2, 0, 1});
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 2) {
                swap(nums, i, right--);
            } else if (i>left && nums[i] == 0) {
                swap(nums, i, left++);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}