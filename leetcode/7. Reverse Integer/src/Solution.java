class Solution {
    public int reverse(int x) {

        long num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        if (num >= Integer.MAX_VALUE || num <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}