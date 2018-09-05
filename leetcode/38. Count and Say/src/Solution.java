class Solution {
    public String countAndSay(int n) {
        String now = "1";
        StringBuilder nex = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < now.length(); j++) {
                char nowChar = now.charAt(j);
                int count = 1;
                while (j+1 < now.length() && now.charAt(j+1) == nowChar) {
                    j++;
                    count++;
                }
                nex.append(count).append(nowChar);
            }
            now = nex.toString();
            nex = new StringBuilder();
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(2));
        System.out.println(new Solution().countAndSay(3));
        System.out.println(new Solution().countAndSay(4));
        System.out.println(new Solution().countAndSay(5));
    }
}