class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;

        int sum = 0;
        while (x != 0) {
            ++sum;
            x &= x - 1;
        }

        return sum;
    }
}