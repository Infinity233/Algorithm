import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return sol(pre, in);
    }

    private TreeNode sol(List<Integer> pre, List<Integer> in) {

        if (pre.size() == 0) {
            return null;
        }

        TreeNode node = new TreeNode(pre.get(0));
        int inIndex = in.indexOf(pre.get(0));
        node.left = sol(pre.subList(1, inIndex + 1), in.subList(0, inIndex));
        node.right = sol(pre.subList(inIndex + 1, pre.size()), in.subList(inIndex + 1, in.size()));
        return node;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode node = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }
}