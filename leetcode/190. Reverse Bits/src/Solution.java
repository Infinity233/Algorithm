public class Solution {
    public int reverseBits(int n) {

        int low = 1;
        int high = 1 << 31;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & low) != 0) {
                res = res | high;
            }

            low <<= 1;
            high >>>= 1;
        }

        return res;
    }
}