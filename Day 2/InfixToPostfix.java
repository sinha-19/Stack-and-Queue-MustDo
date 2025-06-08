import java.util.*;
public class InfixToPostfix {
    /*
     * Problem: Convert an infix expression to postfix (Reverse Polish Notation)
     * Approach: Use stack to store operators. Output operands directly.
     * Time: O(n), Space: O(n)
     */
    public static String convert(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch); // Operand goes directly to result
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else { // Operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
