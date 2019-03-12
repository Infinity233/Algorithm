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

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (begin > end) {
            return res;
        }
        if (begin == end) {
            res.add(new TreeNode(begin));
            return res;
        }

        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generateTrees(begin, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            if (left.size() == 0) {
                if (right.size() == 0) {
                    res.add(new TreeNode(i));
                } else {
                    for (TreeNode node : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = node;
                        res.add(root);
                    }
                }
            } else {
                if (right.size() == 0) {
                    for (TreeNode node : left) {
                        TreeNode root = new TreeNode(i);
                        root.left = node;
                        res.add(root);
                    }
                } else {
                    for (TreeNode lNode : left) {
                        for (TreeNode rNode : right) {
                            TreeNode root = new TreeNode(i);
                            root.left = lNode;
                            root.right = rNode;
                            res.add(root);
                        }
                    }
                }
            }
        }

        return res;
    }
}