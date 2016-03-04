package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem331 {

    public static void main(String[] args) {

        System.out.println(isValidSerialization_2("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public static boolean isValidSerialization_2(String preorder) {

        String s = preorder.replaceAll("\\d+,#,#", "#");
        return s.equals("#") || !s.equals(preorder) && isValidSerialization(s);
    }

    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }

            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
