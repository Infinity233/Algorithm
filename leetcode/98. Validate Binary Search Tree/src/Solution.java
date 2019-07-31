class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if(!left || (pre != null && root.val <= pre.val)) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        System.out.println(s.isValidBST(root));
    }
}