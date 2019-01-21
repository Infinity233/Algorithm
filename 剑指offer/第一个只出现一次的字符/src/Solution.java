public class Solution {
    public int FirstNotRepeatingChar(String str) {

        char[] nums = new char[500];

        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i)] == 1) {
                return str.indexOf(str.charAt(i));
            }
        }
        return -1;
    }
}