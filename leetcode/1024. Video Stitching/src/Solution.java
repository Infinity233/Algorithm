import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int maxn = 100000001;
        int[] prime = new int[maxn];      //就是个素数表
        boolean[] sf = new boolean[maxn];        //判断这个数是不是素数，sf[i]中的i是从1到maxn的数

        int num = 0;        //num 用来记筛到第几个质数
        for (int i = 0; i < maxn; i++) {
            sf[i] = true;
        }
        for (int i = 2; i <= maxn; i++) {          //外层枚举1~maxn
            if (sf[i]) prime[++num] = i;      //如果是质数就加入素数表
            for (int j = 1; j <= num; j++) {       //内层枚举num以内的质数
                if (i * prime[j] >= maxn) break; //筛完结束
                sf[i * prime[j]] = false;      //筛掉...
                if (i % prime[j] == 0) break;   //避免重复筛
            }
        }
        sf[1] = false;
        sf[0] = false;  //1 0 特判

        System.out.println();

    }

    public int videoStitching(int[][] c, int T) {

        Arrays.sort(c, (c1, c2) -> {
            if (c1[0] != c2[0]) {
                return c1[0] - c2[0];
            }
            return c1[1] - c2[1];
        });

//        for (int[] num : c) {
//            System.out.println(num[0] + " " + num[1]);
//        }
        if (c.length < 1 || c[0][0] != 0) {
            return -1;
        }
        int count = 1, r = c[0][1], start = 1;

        for (; c[start][0] == c[start - 1][0]; start++) {
            r = Math.max(r, c[start][1]);
        }
        if (r >= T) {
            return 1;
        }
        for (int i = start; i < c.length; ) {
            if (c[i][0] > r) {
                return -1;
            }
            int maxr = r, j;
            for (j = i; j < c.length && c[j][0] <= r; j++) {
                maxr = Math.max(maxr, c[j][1]);
            }
            i = j;
            r = maxr;
            count++;
            if (r >= T) {
                return count;
            }
//            if (c[i][0] >= c[l][0] && c[i][0] <= c[l][1]) {
//                l = i;
//
//            }
        }

        return -1;
    }
}