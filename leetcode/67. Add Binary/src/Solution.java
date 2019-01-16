class Solution {
    public String addBinary(String a, String b) {

        if (a.length() > b.length()) {
            String t = a;
            a = b;
            b = t;
        }

        int cha = b.length() - a.length();
        for (int i = 0; i < cha; i++) {
            a = "0" + a;
        }
        int jin = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            char ta = a.charAt(i);
            char tb = b.charAt(i);
            if (ta == '1' && tb == '1') {
                if (jin == 1) {
                    sb.insert(0, "1");
                } else {
                    sb.insert(0, "0");
                }
                jin = 1;
            } else if (ta == '1' && tb == '0') {
                if (jin == 1) {
                    sb.insert(0, "0");
                } else {
                    sb.insert(0, "1");
                }
            } else if (ta == '0' && tb == '1') {
                if (jin == 1) {
                    sb.insert(0, "0");
                } else {
                    sb.insert(0, "1");
                }
            } else {
                if (jin == 1) {
                    sb.insert(0, "1");
                } else {
                    sb.insert(0, "0");
                }
                jin = 0;
            }
        }
        if (jin == 1) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("0", "0"));
    }
}