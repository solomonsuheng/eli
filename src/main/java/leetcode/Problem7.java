package leetcode;

/**
 * Created by Suheng on 3/11/16.
 */
public class Problem7 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverst(123));
    }

    private static int reverst(int i) {
        if (i == 0) {
            return 0;
        }

        int sign = 1;
        if (i < 0) {
            sign = -1;
        }

        long number = Math.abs((long) i);
        long sum = 0;
        while (number != 0) {
            sum = sum * 10 + number % 10;
            number = number / 10;
        }

        if ((sign == 1 && sum > Integer.MAX_VALUE) || (sign == -1 && -1*sum < Integer.MIN_VALUE)) {
            return 0;
        }
        return sign * (int) sum;
    }
}
