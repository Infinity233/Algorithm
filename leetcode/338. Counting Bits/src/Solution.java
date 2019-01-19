class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countBits(4);
    }
}