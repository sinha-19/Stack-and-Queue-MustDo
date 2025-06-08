import java.util.*;
public class SlidingWindowMaximum {
    /*
     * Problem: Find max in every sliding window of size k for an array.
     * Approach: Use deque to maintain decreasing elements in current window.
     * Time: O(n), Space: O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length, outSize = n - k + 1;
        int[] result = new int[outSize];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Remove out-of-window indices
            if (!dq.isEmpty() && dq.peekFirst() == i - k) dq.pollFirst();
            // Remove smaller values, keep decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }
}
