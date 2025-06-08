import java.util.*;
public class LFUCache {
    /*
     * Problem: Design LFU (least-freq-use) cache to evict least-freq, eldest on tie.
     * Approach: Use DoubleLinked lists per freq and HashMaps for O(1) ops.
     * Time: O(1) per op, Space: O(capacity)
     */
    private class Node {
        int key, value, freq;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; freq = 1; }
    }
    private class DLList {
        Node head = new Node(0, 0), tail = new Node(0, 0);
        int size = 0;
        DLList() {
            head.next = tail;
            tail.prev = head;
        }
        void add(Node n) {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
            size++;
        }
        void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }
        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }
    private int capacity, minFreq;
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Map<Integer, DLList> freqMap = new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        } else {
            if (nodeMap.size() == capacity) {
                DLList minList = freqMap.get(minFreq);
                Node toRemove = minList.removeLast();
                nodeMap.remove(toRemove.key);
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            freqMap.computeIfAbsent(1, k -> new DLList()).add(node);
            minFreq = 1;
        }
    }
    private void update(Node n) {
        int freq = n.freq;
        DLList oldList = freqMap.get(freq);
        oldList.remove(n);
        if (freq == minFreq && oldList.size == 0) minFreq++;
        n.freq++;
        freqMap.computeIfAbsent(n.freq, k -> new DLList()).add(n);
    }
}
