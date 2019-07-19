import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();

        if(root == null) {
            return true;
        }

        s.push(root.left);
        s.push(root.right);

        while(!s.isEmpty()) {
            TreeNode p = s.pop();
            TreeNode q = s.pop();

            if(p == null && q == null) {
                continue;
            }
            if(q == null || p == null) {
                return false;
            }
            if(q.val != p.val) {
                return false;
            }

            s.push(p.right); s.push(q.left);
            s.push(q.right); s.push(p.left);
        }
        return true;
    }
}