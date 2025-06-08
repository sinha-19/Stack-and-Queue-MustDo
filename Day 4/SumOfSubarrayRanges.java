import java.util.*;
public class SumOfSubarrayRanges {
    /*
     * Problem: Sum(max-min) over all subarrays.
     * Approach: Use monotonic stacks to compute contributions of maxima & minima.
     * Time: O(n), Space: O(n)
     */
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        Deque<Integer> st1 = new ArrayDeque<>(), st2 = new ArrayDeque<>();
        long minSum = 0, maxSum = 0;
        int[] leftMin = new int[n], rightMin = new int[n], leftMax = new int[n], rightMax = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) st1.pop();
            leftMin[i] = st1.isEmpty() ? i + 1 : i - st1.peek();
            st1.push(i);
            while (!st2.isEmpty() && arr[st2.peek()] <= arr[i]) st2.pop();
            leftMax[i] = st2.isEmpty() ? i + 1 : i - st2.peek();
            st2.push(i);
        }
        st1.clear(); st2.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st1.isEmpty() && arr[st1.peek()] >= arr[i]) st1.pop();
            rightMin[i] = st1.isEmpty() ? n - i : st1.peek() - i;
            st1.push(i);
            while (!st2.isEmpty() && arr[st2.peek()] < arr[i]) st2.pop();
            rightMax[i] = st2.isEmpty() ? n - i : st2.peek() - i;
            st2.push(i);
        }
        for (int i = 0; i < n; i++) {
            minSum += (long)arr[i] * leftMin[i] * rightMin[i];
            maxSum += (long)arr[i] * leftMax[i] * rightMax[i];
        }
        return maxSum - minSum;
    }
}
