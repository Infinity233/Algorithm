import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        Arrays.sort(numbers);
        int flag, now, i;

        i = flag = 0;

        while (numbers[i] == 0) {
            i++;
            flag++;
        }

        now = numbers[i];
        for (++i; i < numbers.length; ++i) {
            if (numbers[i] - 1 == now) {
                now = numbers[i];
            } else {
                --flag;

                if (flag < 0) {
                    return false;
                }

                now++;
                --i;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isContinuous(new int[]{1, 2, 3, 6, 4}));
    }
}
