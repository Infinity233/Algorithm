import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        ArrayDeque<node> q = new ArrayDeque<>(1000);
        StringBuilder sb;
        TreeSet<String> set = new TreeSet<>();
        node r = new node(root, "" + (char) (root.val + 'a'));
        q.offer(r);
        while (!q.isEmpty()) {

            node t = q.poll();

            if (t.tree.left == null && t.tree.right == null) {
                sb = new StringBuilder(t.sb);
                set.add(sb.reverse().toString());
                continue;
            }
            if (t.tree.left != null) {
                q.offer(new node(t.tree.left, t.sb + ("" + (char) (t.tree.left.val + 'a'))));
            }
            if (t.tree.right != null) {
                q.offer(new node(t.tree.right, t.sb + ("" + (char) (t.tree.right.val + 'a'))));

            }
        }

        return set.first();
    }
}

class node {
    TreeNode tree;
    String sb;

    public node() {
    }

    public node(TreeNode tree, String sb) {
        this.tree = tree;
        this.sb = sb;
    }
}