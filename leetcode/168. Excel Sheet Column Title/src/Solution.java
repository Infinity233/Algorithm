class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int jin = 26;

        while (n != 0) {
            int mod = n % jin;
            n /= jin;
            if (mod == 0) {
                mod = 26;
                n--;
            }
            sb.append((char) (mod + 'A' - 1));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(28));
    }
}