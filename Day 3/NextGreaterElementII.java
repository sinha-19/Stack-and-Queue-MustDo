import java.util.*;
public class NextGreaterElementII {
    /*
     * Problem: Like NGE but array is circular, wrap around
     * Approach: Traverse array twice in reverse using stack
     * Time: O(n), Space: O(n)
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return res;
    }
}
