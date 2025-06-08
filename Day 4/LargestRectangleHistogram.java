import java.util.*;
public class LargestRectangleHistogram {
    /*
     * Problem: Find the largest rectangle area in a histogram.
     * Approach: Use monotonic stack to compute nearest smaller elements.
     * Time: O(n), Space: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length, maxArea = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
        }
        return maxArea;
    }
}
