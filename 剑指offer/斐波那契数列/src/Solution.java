public class Solution {
    public int Fibonacci(int n) {
        int a = 0, b = 1;

        int[] fib = new int[50];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = a+b;
            a = b;
            b = fib[i];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Fibonacci(39);
    }
}