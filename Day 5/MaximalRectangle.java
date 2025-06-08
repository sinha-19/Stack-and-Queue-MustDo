import java.util.*;
public class MaximalRectangle {
    /*
     * Problem: Find maximal rectangle of 1's in a binary matrix.
     * Approach: For each row, treat it as histogram and apply largest rectangle algorithm.
     * Time: O(m * n), Space: O(n)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] heights = new int[n];
        LargestRectangleHistogram hist = new LargestRectangleHistogram();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, hist.largestRectangleArea(heights));
        }
        return maxArea;
    }
    private class LargestRectangleHistogram {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = heights.length, maxArea = 0;
            for (int i = 0; i <= n; i++) {
                int h = (i == n ? 0 : heights[i]);
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }
}
