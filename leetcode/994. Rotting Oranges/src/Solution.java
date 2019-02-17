import java.util.ArrayDeque;

class Solution {

    static int[][] fang = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int n, m;

    public int orangesRotting(int[][] grid) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        int cnt = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Node(i, j));
                    ++cnt;
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int count = 0, flag=0;
            while (cnt-- != 0) {
                Node t = q.poll();

                for (int i = 0; i < 4; i++) {
                    int tx = t.x + fang[i][0];
                    int ty = t.y + fang[i][1];

                    if (judge(tx, ty, grid)) {
                        q.offer(new Node(tx, ty));
                        grid[tx][ty] = 2;
                        count++;
                        flag = 1;
                    }
                }
            }
            cnt = count;
            if(flag == 1) {
                res++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public static boolean judge(int x, int y, int[][] map) {
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}