class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int[] words = new int[130];
        int result = 1, count;
        int loopLength = s.length() - 1;

        for (int i = 0; i < loopLength; ++i) {
            count = 1;
            words[s.charAt(i)] = 1;

            for (int j = i + 1; j < s.length(); ++j) {
                if (words[s.charAt(j)] == 1) {
                    break;
                }
                words[s.charAt(j)] = 1;
                count++;
            }
            result = Math.max(count, result);
            initWords(words);
        }

        return result;
    }

    static void initWords(int[] words) {
        for (int i = 0; i < words.length; ++i) {
            words[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}