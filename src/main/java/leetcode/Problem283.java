package leetcode;

/**
 * Created by Suheng on 3/13/16.
 */
public class Problem283 {
    public static void main(String[] args) {
        moveZeroes(1, 0, 1);
    }

    public static void moveZeroes(int... nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = 0;
        int j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }else if(nums[i]!=0){
                i++;
            }
        }

        for (int k : nums) {
            System.out.print(k + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
