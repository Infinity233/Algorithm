public class Solution {
    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.NumberOf1(10));
        System.out.println(2 & 10);
    }
}