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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        gogogo(root, 1, list);

        return list;
    }

    private void gogogo(TreeNode node, int level, List<List<Integer>> list) {
        if(node == null) {
            return;
        }
        if (level > list.size()) {
            list.add(new ArrayList<>());
        }

        List<Integer> oneList = list.get(level - 1);
        oneList.add(node.val);
        gogogo(node.left, level + 1, list);
        gogogo(node.right, level + 1, list);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);


        s.levelOrder(root);
    }
}