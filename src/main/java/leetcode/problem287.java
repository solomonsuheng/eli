package leetcode;

/**
 * Created by Suheng on 2/15/16.
 */
public class Problem287 {
    public int findDuplicate(int... nums) {
        boolean[] numberFlag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (numberFlag[nums[i] - 1]) {
                return nums[i];
            } else {
                numberFlag[nums[i] - 1] = true;
            }
        }
        return -1;
    }
}
