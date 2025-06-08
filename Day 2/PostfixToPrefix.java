import java.util.*;
public class PostfixToPrefix {
    /*
     * Problem: Convert postfix expression to prefix
     * Approach: Use stack, combine operands on each operator
     * Time: O(n), Space: O(n)
     */
    public static String convert(String expr) {
        Stack<String> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(ch + a + b);
            }
        }
        return stack.peek();
    }
}
