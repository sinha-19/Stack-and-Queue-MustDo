public class StackWithArray {
    /*
     * Problem: Implement a stack with push, pop, top, and empty operations using an array
     * Approach: Manage 'topIndex' to track the top of stack in a fixed-size array
     * Time: O(1) per operation
     * Space: O(N) for array, where N is capacity
     */
    private int[] arr;
    private int top;
    public StackWithArray(int capacity) {
        arr = new int[capacity];
        top = -1;
    }
    public void push(int x) {
        if (top + 1 >= arr.length) throw new RuntimeException("Stack overflow");
        arr[++top] = x;
    }
    public int pop() {
        if (empty()) throw new RuntimeException("Stack underflow");
        return arr[top--];
    }
    public int top() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return arr[top];
    }
    public boolean empty() {
        return top == -1;
    }
}
