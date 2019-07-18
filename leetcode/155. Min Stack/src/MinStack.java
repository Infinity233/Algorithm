import java.util.Stack;

class MinStack {
    Integer min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        if (x < min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(min)) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}