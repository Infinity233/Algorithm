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

import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] a) {

        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            adjustHeap(a, 0, i);
        }
    }

    private static void adjustHeap(int[] a, int i, int length) {

        int tmp = a[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {

            if (k + 1 < length && a[k + 1] > a[k]) {
                k++;
            }

            if (a[k] > tmp) {
                a[i] = a[k];
                i = k;
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 4, 5, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
