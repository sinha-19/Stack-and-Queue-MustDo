import java.util.*;
public class LRUCache {
    /*
     * Problem: Design LRU cache with get and put operations in O(1).
     * Approach: Use LinkedHashMap with access-order = true.
     * Time: O(1), Space: O(capacity)
     */
    private final LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
