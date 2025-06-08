import java.util.*;
public class BalancedParenthesis {
    /*
     * Problem: Check if a given string of parentheses is balanced
     * Approach: Use a stack to match opening and closing brackets
     * Time: O(n), Space: O(n)
     */
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // push opening
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}
