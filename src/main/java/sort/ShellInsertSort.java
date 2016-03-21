package sort;

/**
 * Created by Suheng on 3/21/16.
 */
public class ShellInsertSort {
    public static void main(String[] args) {
        shellSort(38, 49, 65, 97, 76, 13, 27, 4);
    }

    public static void shellSort(int... nums) {
        int dk = nums.length / 2;
        while (dk >= 1) {
            shellInsertSort(dk, nums);
            dk /= 2;
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void shellInsertSort(int dk, int... nums) {
        for (int i = dk; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int j = i - dk;
                int tmp = nums[i];
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + dk] = nums[j];
                    j -= dk;
                }
                nums[j + dk] = tmp;
            }
        }
    }
}

