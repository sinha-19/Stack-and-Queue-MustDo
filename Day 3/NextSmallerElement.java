import java.util.*;
public class NextSmallerElement {
    /*
     * Problem: Find the next smaller element to the right for each element
     * Approach: Use a decreasing stack from right to left
     * Time: O(n), Space: O(n)
     */
    public static int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
