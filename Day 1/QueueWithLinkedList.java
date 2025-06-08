public class QueueWithLinkedList {
    /*
     * Problem: Implement a queue using a singly linked list
     * Approach: Maintain 'head' (dequeue) and 'tail' (enqueue) pointers
     * Time: O(1) per operation
     * Space: O(n)
     */
    private static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }
    private Node head, tail;
    public void enqueue(int x) {
        Node node = new Node(x);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
    }
    public int dequeue() {
        if (head == null) throw new RuntimeException("Queue is empty");
        int val = head.val;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }
    public int front() {
        if (head == null) throw new RuntimeException("Queue is empty");
        return head.val;
    }
    public boolean empty() {
        return head == null;
    }
}
