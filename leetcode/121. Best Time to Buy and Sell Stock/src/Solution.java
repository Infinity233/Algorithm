class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int p : prices) {

            if (p < min) {
                min = p;
            } else {
                res = Math.max(res, p - min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}