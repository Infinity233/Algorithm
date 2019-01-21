public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNum = new int[index + 1];
        uglyNum[1] = 1;
        int counter = 2;

        int t1 = 1;
        int t2 = 1;
        int t3 = 1;

        while (counter <= index) {

            uglyNum[counter] = Math.min(Math.min(uglyNum[t1] * 2, uglyNum[t2] * 3), uglyNum[t3] * 5);

            while (uglyNum[t1] * 2 <= uglyNum[counter]) {
                t1++;
            }
            while (uglyNum[t2] * 3 <= uglyNum[counter]) {
                t2++;
            }
            while (uglyNum[t3] * 5 <= uglyNum[counter]) {
                t3++;
            }

            counter++;
        }

        return uglyNum[index];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(s.GetUglyNumber_Solution(1500));

    }
}