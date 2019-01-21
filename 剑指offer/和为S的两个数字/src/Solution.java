import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length < 1) {
            return list;
        }

        int i = 0, j = array.length - 1;

        for (; i < j; ) {
            int t = array[i] + array[j];
            if (t == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (t < sum) {
                ++i;
            } else {
                --j;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.FindNumbersWithSum(new int[]{1, 2, 3, 4, 5}, 9));
    }
}