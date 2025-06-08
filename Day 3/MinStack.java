import java.util.*;
public class MinStack {
    /*
     * Problem: Design a stack that supports push, pop, top, and retrieving the minimum element in O(1)
     * Approach: Use two stacks - one for normal values, one for minimums
     * Time: O(1) for all operations, Space: O(n)
     */
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }
    public int top() {
        return mainStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
