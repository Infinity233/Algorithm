public class Solution {
    public int RectCover(int target) {
        target *= 2;
        if (target < 2) {
            return 0;
        }

        return sol(target);
    }

    private int sol(int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        return sol(target - 2) + sol(target - 4);
    }
}