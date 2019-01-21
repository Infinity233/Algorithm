class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    private Boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {

        deep(root);
        return flag;
    }

    public int deep(TreeNode root) {

        if (!flag || root == null) {
            return 0;
        }

        int l = deep(root.left);
        int r = deep(root.right);
        if (Math.abs(l - r) > 1) {
            flag = false;
        }
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        System.out.println(s.IsBalanced_Solution(root));

    }
}