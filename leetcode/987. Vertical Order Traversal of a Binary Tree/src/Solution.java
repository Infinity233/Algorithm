import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<Node> q = new ArrayDeque<>(1000);
        TreeSet<Node> set = new TreeSet<>();
        set.add(new Node(root, 0, 0));
        q.offer(new Node(root, 0, 0));

        while (!q.isEmpty()) {

            Node t = q.poll();

            if (t.node.left != null) {
                Node e = new Node(t.node.left, t.x - 1, t.y - 1);
                set.add(e);
                q.offer(e);
            }

            if (t.node.right != null) {
                Node e = new Node(t.node.right, t.x + 1, t.y - 1);
                set.add(e);
                q.offer(e);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int x = -1;
        while (set.size() != 0) {

            Node now = set.first();
            if (now.x != x) {
                if (t.size() > 0) {

                    res.add(new ArrayList<>(t));
                    t.clear();
                }
            }

            t.add(now.node.val);
            x = now.x;
            set.remove(now);
        }
        if (t.size() > 0) {
            res.add(new ArrayList<>(t));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(s.verticalTraversal(null));
    }
}

class TreeNode {
    int val;
    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

class Node implements Comparable<Node> {
    TreeNode node;

    int x, y;

    public Node() {
    }

    public Node(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.x < o.x) {
            return -1;
        } else if (this.x > o.x) {
            return 1;
        }

        if (this.y < o.y) {
            return 1;
        } else if (this.y > o.y) {
            return -1;
        }
        return this.node.val - o.node.val;
    }
}
