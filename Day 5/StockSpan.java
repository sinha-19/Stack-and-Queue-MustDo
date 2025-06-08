import java.util.*;
public class StockSpan {
    /*
     * Problem: Compute stock span for each day (count of consecutive previous days with lower price).
     * Approach: Use stack storing indices of days with higher prices.
     * Time: O(n), Space: O(n)
     */
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return span;
    }
}
