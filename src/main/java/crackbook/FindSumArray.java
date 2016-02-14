package crackbook;

import java.util.HashMap;

/**
 * Created by Suheng on 12/23/15.
 */
public class FindSumArray {
    public static void main(String[] args) {
        int[] sa = findTheSum(15, 1, 2, 4, 7, 11, 15);
        for(int i:sa){
            System.out.print(i+" ");
        }
    }

    public static int[] findTheSum(int key, int... nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int gap = key - nums[i];
            if (hm.containsKey(gap)) {

                int keyIndex = hm.get(gap);
                if (keyIndex != i) {
                    result[0] = i;
                    result[1] = keyIndex;
                    return result;
                }
            }
        }
        return result;
    }
}
