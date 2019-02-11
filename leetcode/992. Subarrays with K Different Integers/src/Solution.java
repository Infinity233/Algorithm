import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window w1 = new Window();
        Window w2 = new Window();
        int res = 0, l1 = 0, l2 = 0;

        for (int right = 0; right < A.length; right++) {

            int x = A[right];
            w1.add(x);
            w2.add(x);

            while(w1.diff() > K) {
                w1.remove(A[l1++]);
            }
            while(w2.diff() >= K) {
                w2.remove(A[l2++]);
            }

            res += l2 - l1;
        }

        return res;
    }
}

class Window {

    Map<Integer, Integer> window;
    int count;

    public Window() {
        window = new HashMap<>();
        count = 0;
    }

    void add(int x) {
        window.put(x, window.getOrDefault(x, 0) + 1);
        if (window.get(x) == 1) {
            count++;
        }
    }

    void remove(int x) {
        window.put(x, window.get(x) - 1);
        if (window.get(x) == 0) {
            count--;
        }
    }

    int diff() {
        return count;
    }
}