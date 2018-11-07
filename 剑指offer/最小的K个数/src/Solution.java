import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k * 2);
        if (input == null || input.length <= 0 || k <= 0 || input.length < k) {
            return res;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((Comparator.reverseOrder()));

        for (int i : input) {
            if (heap.size() < k) {
                heap.add(i);
            } else {
                Integer t = heap.peek();
                if (t > i) {
                    heap.remove(t);
                    heap.add(i);
                }
            }
        }

        res.addAll(heap);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> integers = s.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println();
    }
}