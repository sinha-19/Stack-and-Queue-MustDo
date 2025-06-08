import java.util.LinkedList;
import java.util.Queue;
public class StackWithQueue {
    /*
     * Problem: Implement a stack (LIFO) using a single queue
     * Approach: On push, enqueue then rotate previous elements behind the new one
     * Time: O(n) for push due to rotation, pop/top O(1)
     * Space: O(n)
     */
    private Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        q.offer(x);
        int sz = q.size();
        while (sz-- > 1) {  // rotate older elements
            q.offer(q.poll());
        }
    }
    public int pop() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.poll();
    }
    public int top() {
        if (q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }
}
