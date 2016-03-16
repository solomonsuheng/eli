package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Suheng on 3/14/16.
 */
public class Problem42Test {
    /**
     * Test method for problem 42
     */
    Problem42 problem42;

    @Rule
    public Timeout grobleTimeout = new Timeout(200);

    @Before
    public void setUp() throws Exception {
        this.problem42 = new Problem42();
    }

    @After
    public void tearDown() throws Exception {
        this.problem42 = null;
    }

}
