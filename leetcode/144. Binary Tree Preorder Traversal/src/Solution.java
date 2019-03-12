import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayDeque<TreeNode> s = new ArrayDeque<>(100);
        List<Integer> res = new ArrayList<>(100);
        TreeNode p = root;

        while (p != null || !s.isEmpty()) {

            while (p != null) {
                s.push(p);
                res.add(p.val);
                p = p.left;
            }

            if (!s.isEmpty()) {
                TreeNode t = s.pop();
                p = t.right;
            }
        }

        return res;
    }
}