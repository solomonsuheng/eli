package leetcode;

import java.util.Stack;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem20 {
    public static void main(String[] args) {
        System.out.println(isValid_2("()))))"));
    }

    public static boolean isValid_2(String s) {
        int len = s.length();
        char[] stack = new char[len + 1];
        int top = 1;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack[top++] = c;
            else if (c == ')' && stack[top - 1] != '(')
                return false;
            else if (c == ']' && stack[top - 1] != '[')
                return false;
            else if (c == '}' && stack[top - 1] != '{')
                return false;
            else
                --top;
        }
        if (top == 1)
            return true;
        return false;
    }

    public static boolean isValid(String s) {
        Stack<Character> opStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}') {
                if (opStack.isEmpty()) {
                    return false;
                }
                if (opStack.pop() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (opStack.isEmpty()) {
                    return false;
                }
                if (opStack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (opStack.isEmpty()) {
                    return false;
                }
                if (opStack.pop() != '[') {
                    return false;
                }
            } else {
                opStack.push(c);
            }
        }

        if (!opStack.isEmpty()) {
            return false;
        }
        return true;
    }


}
