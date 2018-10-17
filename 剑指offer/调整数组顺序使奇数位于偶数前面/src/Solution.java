public class Solution {
    public void reOrderArray(int[] array) {
        int[] nums = new int[array.length];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                nums[count++] = array[i];
            }
        }
        count = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 1) == 0) {
                nums[count--] = array[i];
            }
        }

        System.arraycopy(nums, 0, array, 0, array.length);
    }
}