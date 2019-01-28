class Solution {

    int[][] v;
    int[][] map;
    int[][] fang = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int h, w, sum, ex, ey, sx, sy;
    int res = 0;

    public int uniquePathsIII(int[][] grid) {
        h = grid.length;
        w = grid[0].length;
        map = grid;
        v = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] != -1) {
                    ++sum;
                }
                if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        v[sx][sy] = 1;
        sol(sx, sy, 1);
        int t = res;
        return t;
    }

    public void sol(int x, int y, int step) {

        if (x == ex && y == ey && step == sum) {
            ++res;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tx = x + fang[i][0];
            int ty = y + fang[i][1];
            if (judge(tx, ty)) {
                v[tx][ty] = 1;
                sol(tx, ty, step + 1);
                v[tx][ty] = 0;
            }
        }
    }

    public boolean judge(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w && map[x][y] != -1 && v[x][y] == 0;
    }

    public void test(Integer i) {
        i++;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        Integer i = 0;
        s.test(i);
        System.out.println(i);
    }
}