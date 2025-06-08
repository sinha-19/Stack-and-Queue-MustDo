import java.util.*;
public class RemoveKDigits {
    /*
     * Problem: Remove k digits to make smallest number possible.
     * Approach: Greedy with stack to maintain increasing sequence.
     * Time: O(n), Space: O(n)
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peekLast() > c) {
                st.pollLast();
                k--;
            }
            st.offerLast(c);
        }
        while (k-- > 0) st.pollLast();
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty() && st.peekFirst() == '0') st.pollFirst();
        while (!st.isEmpty()) sb.append(st.pollFirst());
        String res = sb.length() == 0 ? "0" : sb.toString();
        return res;
    }
}
