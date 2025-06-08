public class QueueWithArray {
    /*
     * Problem: Implement a queue with enqueue, dequeue, front, and empty operations using an array
     * Approach: Use circular buffer with head/tail pointers
     * Time: O(1) per operation
     * Space: O(N) for array capacity
     */
    private int[] arr;
    private int head, tail, size;
    public QueueWithArray(int capacity) {
        arr = new int[capacity];
        head = tail = size = 0;
    }
    public void enqueue(int x) {
        if (size == arr.length) throw new RuntimeException("Queue overflow");
        arr[tail] = x;
        tail = (tail + 1) % arr.length;
        size++;
    }
    public int dequeue() {
        if (empty()) throw new RuntimeException("Queue underflow");
        int val = arr[head];
        head = (head + 1) % arr.length;
        size--;
        return val;
    }
    public int front() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return arr[head];
    }
    public boolean empty() {
        return size == 0;
    }
}
