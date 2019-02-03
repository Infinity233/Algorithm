import java.util.ArrayDeque;

class Solution {
    public String simplifyPath(String path) {

        ArrayDeque<String> s = new ArrayDeque<>(path.length());

        for (int i = 0; i < path.length(); i++) {

            for (; i < path.length() && path.charAt(i) == '/'; ++i) ;
            StringBuilder sb = new StringBuilder();
            for (; i < path.length() && path.charAt(i) != '/'; ++i) {
                sb.append(path.charAt(i));
            }

            String now = sb.toString();
            if (".".equals(now)) {
                continue;
            } else if ("..".equals(now)) {
                if (s.size() > 0)
                    s.pollLast();
            } else if (now.length() > 0) {
                s.offer(now);
            }
        }

        StringBuilder sb = new StringBuilder("/");

        while (!s.isEmpty()) {
            sb.append(s.poll());
            if (s.size() != 0) {
                sb.append("/");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }
}