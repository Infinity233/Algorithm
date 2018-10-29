import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {

    static int n, m;
    static int[][] fang = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int now = 0;
    static int[][] v;

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        n = matrix.length;
        m = matrix[0].length;
        v = new int[n][m];

        int counter = m * n;
        ArrayDeque<pair> q = new ArrayDeque<>(counter);
        ArrayList<Integer> list = new ArrayList<>(counter);
        q.offer(new pair(0, 0));
        v[0][0] = 1;
        counter -= 1;
        list.add(matrix[0][0]);
        if (counter == 0) {
            return list;
        }
        pair t;
        while (!q.isEmpty()) {
            t = q.pop();

            int tx, ty;
            tx = t.x + fang[now][0];
            ty = t.y + fang[now][1];

            if (judge(tx, ty)) {
                v[tx][ty] = 1;
                list.add(matrix[tx][ty]);
                q.offer(new pair(tx, ty));
                counter -= 1;
                if (counter == 0) {
                    break;
                }
            } else {
                q.offer(new pair(t.x, t.y));
                now = (now + 1) % 4;
            }
        }
        return list;
    }

    private static boolean judge(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && v[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        ArrayList<Integer> res = new Solution().printMatrix(ints);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}

class pair {

    int x, y;

    public pair() {
    }

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}