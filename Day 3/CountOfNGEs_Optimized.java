import java.util.*;
public class CountOfNGEs_Optimized {
    /*
     * Problem: Count number of elements greater than current element to the right
     * Approach:
     * 1. Use coordinate compression to map values to ranks
     * 2. Traverse from right to left using a Fenwick Tree to count greater elements
     * Time: O(n log n), Space: O(n)
     */
    // Fenwick Tree (BIT) for frequency count
    static class FenwickTree {
        int[] bit;
        FenwickTree(int size) {
            bit = new int[size + 2]; // +2 to handle 1-based indexing
        }
        void update(int index, int value) {
            while (index < bit.length) {
                bit[index] += value;
                index += index & -index;
            }
        }
        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
        // Query sum from (index+1) to end (i.e., count of elements > current)
        int queryGreater(int index) {
            return query(bit.length - 1) - query(index);
        }
    }
    public static int[] countNGEs(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // Step 1: Coordinate compression
        Set<Integer> unique = new TreeSet<>();
        for (int num : nums) unique.add(num);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int num : unique) {
            rank.put(num, r++);
        }
        // Step 2: Fenwick Tree usage
        FenwickTree ft = new FenwickTree(rank.size());
        for (int i = n - 1; i >= 0; i--) {
            int idx = rank.get(nums[i]);
            result[i] = ft.queryGreater(idx);
            ft.update(idx, 1);
        }
        return result;
    }
    // Example usage
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] ngeCount = countNGEs(nums);
        System.out.println("Count of Next Greater Elements to the right:");
        System.out.println(Arrays.toString(ngeCount));
    }
}
