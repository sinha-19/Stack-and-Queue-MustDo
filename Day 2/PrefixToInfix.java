import java.util.*;
public class PrefixToInfix {
    /*
     * Problem: Convert prefix expression to infix
     * Approach: Traverse right to left, use stack to combine operands
     * Time: O(n), Space: O(n)
     */
    public static String convert(String expr) {
        Stack<String> stack = new Stack<>();
        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        return stack.peek();
    }
}
