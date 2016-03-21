package sort;

/**
 * Created by Suheng on 3/21/16.
 */
public class StraightInsertionSort {
    public static void main(String[] args) {
        insertSort(38, 49, 65, 97, 76, 13, 27, 49);
    }

    public static void insertSort(int... nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int tmp = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = tmp;
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
