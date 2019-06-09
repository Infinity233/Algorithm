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

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> s = new ArrayDeque<>(S.length());

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (s.size() == 0) {
                s.push('(');
                continue;
            }
            if (!(s.size() == 1 && c == ')'))
                sb.append(c);
            if (c == ')' && s.peek() == '(') {
                s.pop();
            } else {
                s.push('(');
            }
        }

        return sb.toString();
    }
}