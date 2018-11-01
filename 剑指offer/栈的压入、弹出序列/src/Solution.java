import java.util.ArrayDeque;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayDeque<Integer> main = new ArrayDeque<>(pushA.length * 2);
//        ArrayDeque<Integer> sup = new ArrayDeque<>(pushA.length*2);
        int p1 = 0;
        int p2 = 0;
        Integer top = null;
        while (true) {

            if (!main.isEmpty()) {
                top = main.peek();
            }

            if (top != null && top == popA[p1]) {
                p1++;
                main.pop();
                if (p2 >= pushA.length) {
                    if (main.isEmpty()) {
                        return true;
                    }
                }
            } else {
                if (p2 >= pushA.length) {
                    return false;
                }
                main.push(pushA[p2++]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}