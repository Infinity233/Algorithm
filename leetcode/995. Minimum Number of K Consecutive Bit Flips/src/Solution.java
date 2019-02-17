class Solution {
    public int minKBitFlips(int[] A, int K) {
        int cur = 0, res = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                cur -= A[i - K] / 2;
            if ((cur % 2) == A[i]) {
                if (i + K > A.length) return -1;
                A[i] += 2;
                cur++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }
}