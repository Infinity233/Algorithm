import java.util.Stack;

public class Solution {

    Stack<Integer> main = new Stack<>();
    Stack<Integer> support = new Stack<>();
    Integer minValue = Integer.MAX_VALUE;

    public void push(int node) {
        main.push(node);
        minValue = Math.min(node, minValue);
        support.push(minValue);
    }

    public void pop() {
        main.pop();
        support.pop();
    }

    public int top() {
        return main.peek();
    }

    public int min() {
        return support.peek();
    }
}