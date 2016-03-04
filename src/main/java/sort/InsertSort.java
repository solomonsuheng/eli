package sort;

/**
 * Created by Suheng on 3/4/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        insert_Sort(7, 6, 8, 1, 2, 4, 2, 1);
    }

    public static void insert_Sort(int... nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > temp) {
                    //移动元素
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = temp;
            }
        }
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
