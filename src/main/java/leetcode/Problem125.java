package leetcode;

/**
 * Created by Suheng on 3/14/16.
 */
public class Problem125 {
    public static void main(String[] args) {
        String str = "a.";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        boolean flag = true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startC = s.charAt(start);
            char endC = s.charAt(end);

            if (!isazAZ(startC)) {
                start++;
                continue;
            }
            if (!isazAZ(endC)) {
                end--;
                continue;
            }


            startC = Character.toLowerCase(startC);
            endC = Character.toLowerCase(endC);

            System.out.println(startC+" "+endC);
            if(startC!=endC){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return flag;
    }

    /**
     * is a a-z or A-Z
     */
    public static boolean isazAZ(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || (c >= '0' && c <= '9'));
    }

    public static boolean isEquals(char c1, char c2) {
        if (c1 >= 'a' && c2 >= 'a' || c1 <= 'Z' && c2 <= 'Z') {
            return c1 == c2;
        } else if (c1 >= 'a') {
            return (c1 - 32) == c2;
        } else {
            return (c2 - 32) == c1;
        }
    }
}
