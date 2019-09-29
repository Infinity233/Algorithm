class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        final int[][] fang = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = n * n;
        int index = 0, x = 0, y = 0;

        for (int i = 1; i <= count; i++) {

            res[x][y] = i;

            int tx = x + fang[index][0];
            int ty = y + fang[index][1];
            if (tx >= 0 && tx < n && ty >= 0 && ty < n && res[tx][ty] == 0) {
                x = tx;
                y = ty;
            } else {
                index = (index + 1) % 4;
                x = x + fang[index][0];
                y = y + fang[index][1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateMatrix(2);
    }
}