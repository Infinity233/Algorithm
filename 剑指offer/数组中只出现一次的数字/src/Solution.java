//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        num1[0] = 0;
        num2[0] = 0;
        int split = 0;

        for (int i : array) {
            split ^= i;
        }

        int low = lowbit(split);

        for (int i : array) {
            if ((i & low) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }

    public int lowbit(int x) {
        return x & (-x);
    }
}