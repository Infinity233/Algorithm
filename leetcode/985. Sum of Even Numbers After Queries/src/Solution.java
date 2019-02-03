import java.util.Arrays;

class Solution {
    public int[] sumEvenAfterQueries(int[] a, int[][] queries) {
        int[] res = new int[queries.length];
        int cnt = 0;
        int now = 0;
        for (int i : a) {
            if ((i & 1) == 0) {
                now += i;
            }
        }

        for (int[] q : queries) {
            int index = q[1];
            int val = q[0];
            if ((a[index] & 1) == 1) {
                if ((val & 1) == 1) {
                    now += val + a[index];
                }
            } else {
                if ((val & 1) == 1) {
                    now -= a[index];
                } else {
                    now += val;
                }
            }
            a[index] += val;
            res[cnt++] = now;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }
}