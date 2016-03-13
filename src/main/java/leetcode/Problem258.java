package leetcode;

/**
 * Created by Suheng on 3/13/16.
 */
public class Problem258 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }
        int sum = 0;
        int tmp = num;
        sum = addNum(tmp);
        while (sum > 9) {
            sum = addNum(sum);
        }

        return sum;
    }

    public static int addNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
