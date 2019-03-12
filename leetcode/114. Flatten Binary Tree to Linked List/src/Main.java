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

public class Main {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        int i = 1<<29;
        int n = 1;
        printBit(i);
        if (i >>> 16 == 0) {
            n += 16;
            i <<= 16;
        }
        printBit(i);
        if (i >>> 24 == 0) {
            n += 8;
            i <<= 8;
        }
        printBit(i);
        if (i >>> 28 == 0) {
            n += 4;
            i <<= 4;
        }
        printBit(i);
        if (i >>> 30 == 0) {
            n += 2;
            i <<= 2;
        }
        printBit(i);
        n -= i >>> 31;
        System.out.println(n);
    }

    public static void printBit(int i) {
        ArrayList<Integer> list = new ArrayList<>(32);
        for (int i1 = 0; i1 < 32; i1++) {
            list.add(i & 1);
            i = i >>> 1;
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j));
        }
        System.out.println();
    }
}