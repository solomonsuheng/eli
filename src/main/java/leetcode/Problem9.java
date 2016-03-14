package leetcode;

/**
 * Created by Suheng on 3/13/16.
 */
public class Problem9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100001));
    }

    private static boolean isPalindrome(int num) {
        String s = num + "";
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
