import java.util.*;
public class PrefixToPostfix {
    /*
     * Problem: Convert prefix expression to postfix
     * Approach: Use stack, traverse right to left, build expression
     * Time: O(n), Space: O(n)
     */
    public static String convert(String expr) {
        Stack<String> stack = new Stack<>();
        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(a + b + ch);
            }
        }
        return stack.peek();
    }
}
