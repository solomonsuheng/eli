package _032_LongestValidParentheses;

import leetcode.Problem32;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * Created by Suheng on 3/14/16.
 */
public class SolutionTest {
    /**
     * Test method for Problem_32
     */
    Problem32 problem32;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Before
    public void setUp() throws Exception {
        this.problem32 = new Problem32();
    }

    @After
    public void tearDown() throws Exception {
        this.problem32 = null;
    }

    @Test
    public void test0() throws Exception {
        String s = "";
        int actual = this.problem32.longestValidParentheses(s);
        int excepted = 0;
        assertEquals(s, excepted, actual);
    }

    @Test
    public void test1() throws Exception {
        String s = "()";
        int actual = this.problem32.longestValidParentheses(s);
        int excepted = 2;
        assertEquals(s, excepted, actual);
    }
}

