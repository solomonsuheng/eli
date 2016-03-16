package leetcode;

/**
 * Created by Suheng on 3/14/16.
 */
public class Problem35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid+1;
            }else if(nums[mid]>target){
                high = mid-1;
            }else {
                return mid;
            }
        }

        System.out.println(low+" "+high);
        return low;
    }
}
