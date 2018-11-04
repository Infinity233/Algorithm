import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        find(root, target,t, res);
        return res;
    }

    public void find(TreeNode node ,int remain, ArrayList t, ArrayList res) {
        t.add(node.val);
        int now = remain - node.val;

        if(now < 0) {
            return;
        }

        if(node.right == null && node.left == null && now == 0) {
            res.add(new ArrayList<>(t));
            return;
        }

        if (node.left != null) {
            find(node.left, now, t, res);
            t.remove(t.size()-1);
        }
        if (node.right != null) {
            find(node.right, now, t, res);
            t.remove(t.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> arrayLists = solution.FindPath(root, 15);
        System.out.println(arrayLists);
    }
}