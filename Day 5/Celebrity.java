public class Celebrity {
    /*
     * Problem: Find celebrity who is known by everyone but knows no one.
     * Approach: Use stack to eliminate non-celebrities, then verify.
     * Time: O(n), Space: O(n)
     */
    private boolean knows(int a, int b, boolean[][] M) {
        return M[a][b];
    }
    public int findCelebrity(int n, boolean[][] M) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) stack.push(i);
        while (stack.size() > 1) {
            int a = stack.pop(), b = stack.pop();
            if (knows(a, b, M)) stack.push(b);
            else stack.push(a);
        }
        int cand = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (knows(cand, i, M) || !knows(i, cand, M)) return -1;
        }
        return cand;
    }
}
