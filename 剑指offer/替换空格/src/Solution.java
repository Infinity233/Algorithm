public class Solution {

    public String replaceSpace(StringBuffer str) {
        int index = -1;
        while ((index = str.indexOf(" ")) != -1) {
            str.replace(index, index+1, "%20");
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(new StringBuffer("asd as ad")));
    }
}
