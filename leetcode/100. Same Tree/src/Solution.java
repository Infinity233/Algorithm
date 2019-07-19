import java.util.ArrayDeque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        while ((!s1.isEmpty() && !s2.isEmpty()) || (p != null && q != null)) {

            while(p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                s1.push(p);
                s2.push(q);
                p = p.left;
                q = q.left;
            }
            if(s1.size() != s2.size() || p != q) {
                return false;
            }
            if(!s1.isEmpty()) {
                p = s1.pop();
                q = s2.pop();

                p = p.right;
                q = q.right;
            } else {
                return false;
            }
        }
        return s1.size() == s2.size() && p == q;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        root2.right = new TreeNode(3);

        System.out.println(s.isSameTree(root1, root2));
    }
}