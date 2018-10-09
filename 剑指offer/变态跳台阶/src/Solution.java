public class Solution {
    public int JumpFloorII(int target) {
        int sum = 1, now = 1;

        for (int i = 2; i <= target; i++) {
            now = sum+1;
            sum += now;
        }

        return now;
    }
}