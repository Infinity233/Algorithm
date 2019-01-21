public class Solution {

    public int Sum_Solution(int n) {
        int result = 0;
        int temp = 0;
        boolean flag = n > 0 && temp == (result = Sum_Solution(n - 1));
        return result + n;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Sum_Solution(100));
    }
}
