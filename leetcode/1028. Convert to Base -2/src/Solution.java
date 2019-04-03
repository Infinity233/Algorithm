class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.baseNeg2(0);
    }

    public String baseNeg2(int n) {
        if(n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int a = Math.abs(n % (-2));
            sb.insert(0, a);
            n = (n - a) / -2;
        }
        System.out.println(sb);
        return sb.toString();
    }
}