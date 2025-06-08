import java.util.*;
public class InfixToPrefix {
    /*
     * Problem: Convert infix expression to prefix
     * Approach:
     *   1. Reverse the expression
     *   2. Swap '(' and ')'
     *   3. Convert to postfix
     *   4. Reverse result
     * Time: O(n), Space: O(n)
     */
    public static String convert(String s) {
        StringBuilder input = new StringBuilder(s).reverse();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') input.setCharAt(i, ')');
            else if (input.charAt(i) == ')') input.setCharAt(i, '(');
        }
        String revInfix = input.toString();
        String revPostfix = toPostfix(revInfix);
        return new StringBuilder(revPostfix).reverse().toString();
    }
    private static String toPostfix(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) res.append(stack.pop());
        return res.toString();
    }
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
