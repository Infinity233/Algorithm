public class Solution {
    public int JumpFloor(int target) {
        if (target == 1 || target == 0) {
            return 1;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}