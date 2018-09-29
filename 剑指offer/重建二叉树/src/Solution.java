import java.util.Arrays;

public class Solution {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        int midIndex = findVal(in, pre[0]);

        if (pre.length == 1) {
            return root;
        }

        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, midIndex + 1), Arrays.copyOfRange(in, 0, midIndex));
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, midIndex + 1, pre.length), Arrays.copyOfRange(in, midIndex + 1, in.length));
        return root;
    }

    public static Integer findVal(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (target == a[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
        System.out.println(treeNode);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
