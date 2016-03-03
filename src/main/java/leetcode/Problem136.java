package leetcode;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Suheng on 2/29/16.
 */
public class Problem136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(-1, -1, -2));

    }

    public static int singleNumber(int... nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                ht.put(nums[i], ht.get(nums[i]) + 1);
            } else {
                ht.put(nums[i], 1);
            }
        }
        System.out.println(ht);

        Iterator iter = ht.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getValue();
            if (key == 1) {
                return (Integer) entry.getKey();
            }
        }
        return result;
    }
}
