//
//                                  _oo8oo_
//                                 o8888888o
//                                 88" . "88
//                                 (| -_- |)
//                                 0\  =  /0
//                               ___/'==='\___
//                             .' \\|     |// '.
//                            / \\|||  :  |||// \
//                           / _||||| -:- |||||_ \
//                          |   | \\\  -  /// |   |
//                          | \_|  ''\---/''  |_/ |
//                          \  .-\__  '-'  __/-.  /
//                        ___'. .'  /--.--\  '. .'___
//                     ."" '<  '.___\_<|>_/___.'  >' "".
//                    | | :  `- \`.:`\ _ /`:.`/ -`  : | |
//                    \  \ `-.   \_ __\ /__ _/   .-` /  /
//                =====`-.____`.___ \_____/ ___.`____.-`=====
//                                  `=---=`
//
//
//               ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//                          佛祖保佑         永不宕机/永无bug
//


import java.util.ArrayDeque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public void flatten(TreeNode root) {

        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        TreeNode p, q = null;
        p = root;
        TreeNode res = null;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.right;
            }

            if (!s.isEmpty()) {
                p = s.peek();
                if (p.left == null || q == p.left) {
                    p.right = res;
                    p.left = null;
                    res = p;
                    System.out.println(p.val);
                    q = p;
                    p = null;
                    s.pop();
                } else {
                    p = p.left;
                }
            }
        }
        root = res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution s = new Solution();
        s.flatten(root);
    }
}