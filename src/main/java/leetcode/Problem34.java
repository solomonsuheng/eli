package leetcode;

/**
 * Created by Suheng on 3/14/16.
 */
public class Problem34 {
    public static void main(String[] args) {
        System.out.println(binarySearch(4, 2, 3, 4, 4, 5, 6, 7, 8));
    }


    public static int[] binarySearch(int target, int... nums) {
        int low = 0;
        int high = nums.length - 1;
        int[] result = {-1, -1};
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target) {
            result[0] = low;
        } else {
            return result;
        }

        high = nums.length - 1;
        while (low < high) {
            int mid = (high + low + 1) / 2;
            if (nums[mid] == target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        result[1] = high;

        return result;
    }

    public static int[] searchRange(int target, int... nums) {
        int[] result = {3, 4};

        return result;
    }
}
