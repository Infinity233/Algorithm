import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i : A) {
            sb.append(i);
        }
        BigInteger num = new BigInteger(sb.toString());
        BigInteger ZERO = new BigInteger("0");
        BigInteger TEN = new BigInteger("10");
        num = num.add(new BigInteger(K + ""));

        List<Integer> res = new LinkedList<>();

        if(num.equals(ZERO)) {
            res.add(0);
            return res;
        }

        while (num.compareTo(ZERO) > 0) {
            res.add(0, num.remainder(TEN).intValue());
            num = num.divide(TEN);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addToArrayForm(new int[]{0}, 0));
    }
}