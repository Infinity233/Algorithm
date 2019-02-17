import java.util.ArrayDeque;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        map.put(root.val, -1);
        nodeMap.put(root.val, null);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            Integer now = map.get(t.val);
            if (t.left != null) {
                q.offer(t.left);
                map.put(t.left.val, now + 1);
                nodeMap.put(t.left.val, t);
            }
            if (t.right != null) {
                q.offer(t.right);
                map.put(t.right.val, now + 1);
                nodeMap.put(t.right.val, t);
            }
        }

        return map.get(x).equals(map.get(y)) && nodeMap.get(x) != nodeMap.get(y);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(s.isCousins(root, 2, 3));
    }
}