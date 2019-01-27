class Solution {
    public String strWithout3a3b(int A, int B) {

        StringBuilder sb = new StringBuilder();
        if(A == 1  && B == 1) {
            return "ab";
        }

        Character c1, c2;
        if (A > B) {
            c1 = 'a';
            c2 = 'b';
        } else {
            c1 = 'b';
            c2 = 'a';
            int t = A;
            A = B;
            B = t;
        }

        for (int i = 0; i < A; i++) {
            sb.append(c1);
        }
        int index = 2, step = 3;
        for (int i = 0; i < B; i++) {
            if (index > sb.length()) {
                sb.insert(sb.length(), c2);
                index = 2;
                step += 1;
                continue;
            }
            sb.insert(index, c2);
            index += step;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strWithout3a3b(3, 3));
        StringBuilder sb = new StringBuilder("12345");
        System.out.println(sb.insert(5,'a').toString());
    }
}