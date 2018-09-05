public class test {

    public static void main(String[] args) {
        System.out.println(test.encrypyMsg("abcde", new int[]{4, 3, 2, 1, 0}, 2));

    }

    public static String encrypyMsg(String msg, int key[], int count) {
        StringBuilder sb = new StringBuilder(msg);
        String t;
        for (int k = 0; k < count; k++) {
            t = sb.toString();
            for (int i = 0; i < sb.length(); i++) {
                sb.replace(i, i + 1, t.charAt(key[i]) + "");
            }
        }

        return sb.toString();
    }
}
