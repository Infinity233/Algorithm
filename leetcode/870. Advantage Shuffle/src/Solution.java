import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {

        int n = B.length;
        int[] res = new int[n];
        ArrayList<Node> b = new ArrayList<>(n);
        Map<Integer, Integer> map = new HashMap<>(n * 2);

        for (int i = 0; i < B.length; i++) {
            Node node = new Node();
            node.val = B[i];
            node.index = i;
            b.add(node);
        }

        b.sort((x, y) -> y.val - x.val);
        Arrays.sort(A);

        int hi;
        int lo;
        int cnt = n;
        hi = n - 1;
        lo = 0;

        for (int i = 0; i < n; i++) {
            int index = b.get(i).index, val = b.get(i).val;

            if (A[hi] > val) {
                res[index] = A[hi--];

            } else{
                res[index] = A[lo++];

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}

class Node {
    int val, index;
}