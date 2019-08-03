class Solution {
    public String minWindow(String s, String t) {

        int[] map = new int[150];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int count = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {

            if (map[s.charAt(end++)]-- > 0)
                count--;
            while (count == 0) {
                if (end - begin < d)
                    d = end - (head = begin);
                if (map[s.charAt(begin++)]++ == 0)
                    count++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, d);
    }

    public String minWindow2(String ss, String tt) {

        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        int[] map = new int[150];
        for (char c : t) {
            map[c]++;

        }

        int counter = t.length, begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while(end<s.length){
            if(map[s[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s[begin++]]++==0) counter++;  //make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : ss.substring(head, d);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow2("ADOBECODEBANC", "ABC"));
    }
}