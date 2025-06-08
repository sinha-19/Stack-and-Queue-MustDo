public class StackWithLinkedList {
    /*
     * Problem: Implement a stack using a singly linked list
     * Approach: Push/pop at head for O(1) operations
     * Time: O(1) per operation
     * Space: O(n)
     */
    private static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }
    private Node head;
    public void push(int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
    }
    public int pop() {
        if (head == null) throw new RuntimeException("Stack is empty");
        int val = head.val;
        head = head.next;
        return val;
    }
    public int top() {
        if (head == null) throw new RuntimeException("Stack is empty");
        return head.val;
    }
    public boolean empty() {
        return head == null;
    }
}
