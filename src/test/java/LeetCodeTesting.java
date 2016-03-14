import leetcode.Problem241;
import leetcode.Problem287;
import leetcode.Problem32;
import leetcode.Problem49;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Suheng on 2/15/16.
 */
public class LeetCodeTesting {
    @Test
    public void testProblem241() throws Exception {
        Problem241 p = new Problem241();
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(11);
        test.add(20);
        assertEquals(test, p.diffWaysToCompute("3+2*4"));
    }

    @Test
    public void testProblem287() throws Exception {
        Problem287 p = new Problem287();
        assertEquals(5, p.findDuplicate(1, 2, 3, 4, 5, 6, 7, 8, 9, 5));
    }

    @Test
    public void testProblem32() throws Exception {
        Problem32 problem32 = new Problem32();
        assertEquals(2, problem32.longestValidParentheses("()"));
        assertEquals(2, problem32.longestValidParentheses("(()"));
        assertEquals(2, problem32.longestValidParentheses("())"));
        assertEquals(2, problem32.longestValidParentheses("()))"));
        assertEquals(2, problem32.longestValidParentheses("(((()"));

        assertEquals(4, problem32.longestValidParentheses(")()())"));

        assertEquals(6, problem32.longestValidParentheses("(()())"));
        assertEquals(6, problem32.longestValidParentheses("()()()"));
        assertEquals(6, problem32.longestValidParentheses("((()))"));
    }

    @Test
    public void testProblem49() throws Exception {

        Problem49 p = new Problem49();



    }
}
