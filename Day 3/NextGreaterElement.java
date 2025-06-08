import java.util.*;
public class NextGreaterElement {
    /*
     * Problem: For each element, find the next greater element to the right
     * Approach: Traverse from right to left using a monotonic stack
     * Time: O(n), Space: O(n)
     */
    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller elements
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
