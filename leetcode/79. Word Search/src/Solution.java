class Solution {

    private static String w;
    private static char[][] b;
    private static int[][] v;
    private static int width, height;
    private static final int[][] fang = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) {
            return true;
        }

        b = board;
        w = word;
        height = board.length;
        width = board[0].length;
        v = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (b[i][j] == w.charAt(0)) {
                    v[i][j] = 1;
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                    v[i][j] = 0;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int index) {
        if (w.charAt(index) == b[x][y]) {

            if (index >= w.length() - 1) {
                return true;
            }

            int tx, ty;
            for (int i = 0; i < 4; i++) {
                tx = x + fang[i][0];
                ty = y + fang[i][1];

                if (judge(tx, ty)) {
                    v[tx][ty] = 1;
                    boolean tb = dfs(tx, ty, index + 1);
                    v[tx][ty] = 0;

                    if (tb) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean judge(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width && v[x][y] == 0;
    }

    public static void main(String[] args) {

//        char[][] map = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };

        char[][] map = {{'a'}};

        Solution s = new Solution();
        System.out.println(s.exist(map, "ab"));
    }
}