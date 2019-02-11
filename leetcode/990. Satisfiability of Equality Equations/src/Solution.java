class Solution {

    int maxn = 200;
    int[] pre = new int[maxn];

    int Find(int x) {
        int p, tmp;
        p = x;
        while (x != pre[x])
            x = pre[x];
        while (p != x) {
            tmp = pre[x];
            pre[x] = x;
            p = tmp;
        }
        return x;
    }

    void join(int x, int y) {
        int fx = Find(x);
        int fy = Find(y);
        if (fx != fy)
            pre[fx] = fy;
    }

    boolean Same(int x, int y) {
        return Find(x) == Find(y);
    }

    public boolean equationsPossible(String[] equations) {

        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }

        for (String e : equations) {
            char c1 = e.charAt(0);
            char c2 = e.charAt(3);

            if (e.charAt(1) == '=') {
                join(c1, c2);
            }
        }
        for (String e : equations) {
            char c1 = e.charAt(0);
            char c2 = e.charAt(3);

            if (e.charAt(1) == '!') {
                if (Same(c1, c2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}