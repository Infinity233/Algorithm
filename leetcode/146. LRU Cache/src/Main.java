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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (s == null || s.length() <= 0 || s.equals("None")) {
            System.out.println("False");
            return;
        }
        int[] a = new int[10005];
        int count = 0;
        String[] nums = s.split(",");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals("None")) {
                System.out.println("False");
                return;
            }
            a[i + 1] = Integer.parseInt(nums[i]);
            if (!(a[i + 1] > 0 && a[i + 1] < 65536)) {
                System.out.println("False");
                return;
            }
            ++count;
        }
        if (nums.length <= 0) {
            System.out.println("False");
            return;
        }
        zhong(a, count, 1);
        int pre = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i < pre) {
                System.out.println("False");
                return;
            } else {
                pre = i;
            }
        }
        System.out.println("True");
    }

    private static void zhong(int[] arr, int count, int index) {
        if (index <= count) {

            zhong(arr, count, index * 2);
            list.add(arr[index]);
            zhong(arr, count, index * 2 + 1);
        }
    }
}