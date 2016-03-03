package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem66 {
    public static void main(String[] args) {
        int[] nums = plusOne(9, 9, 9);

        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static int[] plusOne(int... digits) {
        int carry = 0;

        int number = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry + number;
            number = 0;
            digits[i] = temp % 10;
            carry = temp / 10;
        }

        if (carry == 1) {
            int[] nums = new int[digits.length + 1];
            nums[0] = carry;
            for (int n = 1; n < nums.length; n++) {
                nums[n] = digits[n - 1];
            }
            return nums;
        } else {
            return digits;
        }
    }
}
