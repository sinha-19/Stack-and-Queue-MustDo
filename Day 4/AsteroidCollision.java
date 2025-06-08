import java.util.*;
public class AsteroidCollision {
    /*
     * Problem: Simulate asteroids moving and colliding.
     * Approach: Use stack to manage surviving asteroids on collisions.
     * Time: O(n), Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int a : asteroids) {
            collision:
            if (a > 0) {
                st.push(a);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) st.pop();
                if (!st.isEmpty() && st.peek() == -a) st.pop();
                else if (st.isEmpty() || st.peek() < 0) st.push(a);
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) res[i] = st.pop();
        return res;
    }
}
