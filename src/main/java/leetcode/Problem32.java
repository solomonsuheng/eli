package leetcode;

import java.util.Stack;

/**
 * Created by Suheng on 3/14/16.
 */
public class Problem32 {
    public static void main(String[] args) {
        Problem32 e = new Problem32();
        System.out.println(e.longestValidParentheses("()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    nums[stack.pop()] = 1;
                    nums[i] = 1;
                }
            } else {
                //do nothing
            }
        }

        int tmp = 0;
        for (int i : nums) {
            if (i == 1) {
                tmp++;
            } else {
                count = (count < tmp) ? tmp : count;
                tmp = 0;
            }
        }

        return (count > tmp) ? count : tmp;
    }
}

