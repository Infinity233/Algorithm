class Solution {

    static int[][] fang = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static int[][] map;
    static int m, n;

    public void gameOfLife(int[][] board) {
        map = board;
        m = board.length;
        n = board[0].length;
        int[][] num = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = cnt(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (num[i][j] < 2 || num[i][j] > 3) {
                    board[i][j] = 0;
                } else if (num[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int cnt(int x, int y) {
        int tx, ty, res = 0;
        for (int i = 0; i < 8; i++) {
            tx = x + fang[i][0];
            ty = y + fang[i][1];
            if (judge(tx, ty) && map[tx][ty] == 1) {
                ++res;
            }
        }
        return res;
    }

    public boolean judge(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.gameOfLife(new int[][]{{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}});
    }
}