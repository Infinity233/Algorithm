class Solution {
    public int brokenCalc(int x, int y) {

        return x >= y ? x - y : (1 + brokenCalc(x, (y & 1) == 1 ? y + 1 : y / 2));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.brokenCalc(5, 8));
    }
}