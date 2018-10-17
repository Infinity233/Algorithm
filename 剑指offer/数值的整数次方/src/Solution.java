public class Solution {
    public double Power(double base, int exponent) {
        int res = 1;

        while(exponent!=0) {
            if ((exponent &1) !=0) {
                res*=base;
            }
            base*=base;
            exponent>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Power(3, 3));
    }
}