class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    private static boolean s = false;

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (s) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            boolean sub = isSub(root1, root2);
            if (sub) {
                s = true;
                return true;
            }
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isSub(a.left, b.left) && isSub(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        a.left = new TreeNode(8);
        a.right = new TreeNode(7);
        a.left.left = new TreeNode(9);
        a.left.right = new TreeNode(3);
        a.left.right.left = new TreeNode(4);
        a.left.right.right = new TreeNode(7);

        TreeNode b = new TreeNode(8);
        b.left = new TreeNode(8);
        b.right = new TreeNode(6);

        System.out.println(new Solution().HasSubtree(a, b));
    }
}