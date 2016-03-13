package leetcode;

/**
 * Created by Suheng on 3/13/16.
 */
public class Problem231 {
    public static void main(String[] args) {
        int num = 2312;
        System.out.println(isPowerOfTwo_2(num));
        System.out.println(2 << 2);
    }

    public static boolean isPowerOfTwo_2(int num) {
        if (num <= 0) {
            return false;
        }
        int i = 0;
        while (num != (2 << i)) {
            i++;
            if ((2 << i) > num) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        }

        boolean flag = true;
        int tmp = n;
        while (tmp != 2) {
            if (tmp % 2 != 0) {
                return false;
            } else {
                tmp /= 2;
            }
        }
        return flag;
    }
}
