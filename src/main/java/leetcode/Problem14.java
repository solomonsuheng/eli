package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem14 {
    public static void main(String[] args) {
        String[] strs = {"ad", "azxc", "aqiweqwe", "asd"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer(strs[0]);
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(sb.toString())) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
