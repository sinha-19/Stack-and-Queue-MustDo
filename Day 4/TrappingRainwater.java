import java.util.*;
public class TrappingRainwater {
    /*
     * Problem: Given heights[], compute total water trapped.
     * Approach: Use monotonic decreasing stack to track boundaries.
     * Time: O(n), Space: O(n) stack
     */
    public int trap(int[] height) {
        Deque<Integer> st = new ArrayDeque<>();
        int ans = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) break;
                int left = st.peek();
                int width = i - left - 1;
                int bounded = Math.min(height[left], height[i]) - height[top];
                ans += width * bounded;
            }
            st.push(i);
        }
        return ans;
    }
}
