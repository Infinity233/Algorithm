import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>(100);

        if (root != null) {
            q.push(root);
        }
        TreeNode t;
        while (!q.isEmpty()) {
            t = q.poll();

            res.add(t.val);

            if (t.left != null) {
                q.offer(t.left);
            }

            if (t.right != null) {
                q.offer(t.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}