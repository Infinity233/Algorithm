import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {

        Map<Integer, Integer> map = new HashMap<>(array.length * 2);
        int cap = array.length / 2;

        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            Integer t = map.get(i);
            ++t;
            if (t > cap) {
                return i;
            }

            map.put(i, t);
        }
        return 0;
    }

    public int sole(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int result = arr[0];
        int time = 1;

        for (int i = 1; i < arr.length; i++) {
            if(time == 0) {
                result = arr[i];
                time = 1;
            }

            if(arr[i] == result) {
                time++;
            } else {
                time--;
            }
        }

        return result;
    }
}