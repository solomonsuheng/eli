package leetcode;

/**
 * Created by Suheng on 3/16/16.
 */
public class Problem189 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1 || nums == null) {
            return;
        }
        int index = nums.length - k;

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, nums.length - index - 1);
        reverse(nums, nums.length - index, nums.length - 1);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }


    public static void reverse(int[] nums, int i, int j) {
        for (int k = i, m = j; k <= m; k++, m--) {
            swap(nums, m, k);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
