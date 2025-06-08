import java.util.*;
public class PostfixToInfix {
    /*
     * Problem: Convert postfix expression to infix
     * Approach: Push operands to stack, combine when operator is found
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
                stack.push("(" + a + ch + b + ")");
            }
        }
        return stack.peek();
    }
}
