import java.util.ArrayList;
import java.util.List;

class Solution {

    static int h;
    static int w;
    static int[][] v;

    public List<Integer> spiralOrder(int[][] matrix) {
        h = matrix.length;
        if (h <= 0) {
            return new ArrayList<>();
        }
        w = matrix[0].length;
        v = new int[h][w];
        v[0][0] = 1;

        int[][] fang = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = h * w - 1;
        int x = 0, y = 0;
        List<Integer> res = new ArrayList<>(h * w);
        res.add(matrix[0][0]);
        while (count > 0) {

            for (int i = 0; i < 4; i++) {

                while (true) {
                    int tx = x + fang[i][0];
                    int ty = y + fang[i][1];

                    if (judge(tx, ty)) {
                        x = tx;
                        y = ty;
                        v[x][y] = 1;
                        res.add(matrix[x][y]);
                        count--;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }

    private boolean judge(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w && v[x][y] == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.spiralOrder(new int[][]{}));
    }
}