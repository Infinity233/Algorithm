class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {

        TreeNode sol = sol(pRootOfTree);
        if (sol!=null) {
            while (sol.left != null) {
                sol = sol.left;
            }
        }
        return sol;
    }

    private TreeNode sol(TreeNode mid) {
        if (mid == null) {
            return null;
        }
        if (mid.left == null && mid.right == null) {
            return mid;
        }

        TreeNode left = sol(mid.left);
        TreeNode right = sol(mid.right);

        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            mid.left = left;
            left.right = mid;
        }


        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            mid.right = right;
            right.left = mid;
        }

        return mid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(2);
        node.left.left.left.left = new TreeNode(1);
        TreeNode sol = s.Convert(null);
        System.out.println();
    }
}