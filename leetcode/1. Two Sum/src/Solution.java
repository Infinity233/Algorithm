import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> numList = new ArrayList<>(nums.length * 2);

        for (int i : nums) {
            numList.add(i);
        }

        int[] validNums = new int[nums.length];
        int validIndex = 0;
        for (int i : nums) {
            validNums[validIndex++] = i;
        }
        Arrays.sort(validNums, 0, validIndex);
        int temp, res;
        for (int i = 0; i < validIndex; i++) {
            temp = target - validNums[i];

            res = erfen(validNums, validIndex, i, temp);
            if (res != -1) {

                int res1 = numList.indexOf(validNums[i]);
                int res2 = numList.indexOf(validNums[res]);
                if (res1 > res2) {
                    int t = res1;
                    res1 = res2;
                    res2 = t;
                } else if (res1 == res2) {
                    res2 = numList.lastIndexOf(validNums[res]);
                }
                return new int[]{res1, res2};
            }
        }
        return null;
    }

    static int erfen(int[] nums, int right, int left, int target) {

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < target) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3,4,3,90};
        System.out  .println(Arrays.toString(new Solution().twoSum(nums, 0)));
    }
}