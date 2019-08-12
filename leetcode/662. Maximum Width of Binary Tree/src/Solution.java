import java.util.ArrayDeque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    TreeNode node;
    int val;

    public Node(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {

    int res = 0;

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {

            res = Math.max(res, q.getLast().val - q.getFirst().val);
            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node node = q.poll();
                TreeNode node1 = node.node;
                if (node1.left != null) {
                    q.offer(new Node(node1.left, node.val * 2));
                }
                if (node1.right != null) {
                    q.offer(new Node(node1.right, node.val * 2 + 1));
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution s = new Solution();
        System.out.println(s.widthOfBinaryTree(root));
    }
}