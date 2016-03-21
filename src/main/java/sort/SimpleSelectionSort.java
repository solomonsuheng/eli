package sort;

/**
 * Created by Suheng on 3/21/16.
 */
public class SimpleSelectionSort {
    public static void main(String[] args) {
        selectionSort(38, 49, 65, 97, 76, 13, 27, 49);
    }

    public static void selectionSort(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
