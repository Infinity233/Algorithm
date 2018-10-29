import java.util.ArrayDeque;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode t = root;

        while (t != null || !s.isEmpty()) {

            while(t!=null) {
                TreeNode tt = t.left;
                t.left = t.right;
                t.right = tt;

                s.push(t);
                t = t.left;
            }

            if (!s.isEmpty()) {
                t = s.pop();
                t = t.right;
            }
        }
    }
}