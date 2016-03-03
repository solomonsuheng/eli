package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Suheng on 3/2/16.
 */
public class Problem187 {
    public static void main(String[] args) {
        Set<String> resset = new HashSet<String>();
        Set<String> set = new HashSet<String>();


        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        Set<String> resset = new HashSet<String>();
        if (s == null || s.length() <= 10) {
            return res;
        }

        Set<String> set = new HashSet<String>();
        int len = s.length();

        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }
}
