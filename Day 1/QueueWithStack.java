import java.util.Stack;
public class QueueWithStack {
    /*
     * Problem: Implement a queue (FIFO) using two stacks
     * Approach: Enqueue to 'inStack'; dequeue from 'outStack', transfer when needed
     * Time: Amortized O(1) per operation (worst-case O(n))
     * Space: O(n)
     */
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    public void enqueue(int x) {
        in.push(x);
    }
    public int dequeue() {
        shift();
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.pop();
    }
    public int front() {
        shift();
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.peek();
    }
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    private void shift() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
    }
}
