public class Solution {
    public boolean Find(int target, int[][] a) {
        int height = 0;
        int width = a[0].length - 1;

        while (width>=0 && height<a.length) {
            if (a[height][width] == target) {
                return true;
            } else if (a[height][width] > target) {
                width--;
            } else {
                height++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.Find(7, new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}}));
        System.out.println(solution.Find(7, new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}));
    }
}