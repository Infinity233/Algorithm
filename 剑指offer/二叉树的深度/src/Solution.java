import java.util.ArrayDeque;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class com {
    TreeNode node;
    int deepth;

    public com(TreeNode node, int deepth) {
        this.node = node;
        this.deepth = deepth;
    }
}

public class Solution {

    public int TreeDepth(TreeNode root) {
        int res = 0;
        int deepth = 0;
        ArrayDeque<com> s = new ArrayDeque<>(100);
        while (root != null || !s.isEmpty()) {

            while (root != null) {
                deepth++;
                s.push(new com(root, deepth));
                root = root.left;
            }

            if (!s.isEmpty()) {
                com t = s.pop();
                res = Math.max(res, t.deepth);
                root = t.node.right;
                deepth = t.deepth;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        System.out.println(s.TreeDepth(root));
    }
}