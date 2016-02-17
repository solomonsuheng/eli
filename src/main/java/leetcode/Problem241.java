package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suheng on 2/17/16.
 */
public class Problem241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int a1 : al) {
                    for (int b1 : bl) {
                        if (c == '-') {
                            list.add(a1 - b1);
                        } else if (c == '*') {
                            list.add(a1 * b1);
                        }
                        if (c == '+') {
                            list.add(a1 + b1);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
