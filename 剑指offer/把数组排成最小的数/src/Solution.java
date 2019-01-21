import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>(numbers.length * 2);
        for (int number : numbers) {
            list.add(number + "");
        }

        list.sort(((o1, o2) -> {

            String n1 = o1 + "" + o2;
            String n2 = o2 + "" + o1;

            for (int i = 0; i < n1.length(); i++) {
                if (n1.charAt(i) < n2.charAt(i)) {
                    return -1;
                } else if (n1.charAt(i) > n2.charAt(i)) {
                    return 1;
                }
            }
            return 1;
        }));
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.PrintMinNumber(new int[]{32, 3, 321}));
    }
}