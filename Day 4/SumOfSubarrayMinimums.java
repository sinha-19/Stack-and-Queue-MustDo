import java.util.*;
public class SumOfSubarrayMinimums {
    /*
     * Problem: Sum of minimums of all subarrays.
     * Approach: Use monotonic stack to count contribution of each element.
     * Time: O(n), Space: O(n)
     */
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007, n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        long res = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            res = (res + (long) arr[i] * left[i] * right[i]) % MOD;
        }
        return (int) res;
    }
}
