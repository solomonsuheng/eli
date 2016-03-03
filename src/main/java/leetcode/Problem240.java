package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem240 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix_2(matrix, 5));
    }

    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix.length - 1]) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[row - 1].length;

        //target和每行头尾部比较,如果在中间那么二分发查找
        for (int i = 0; i < row; i++) {
            //target在该行
            //二分法查找

            if ((target < matrix[i][col - 1]) & binarySearch(matrix[i], 0, matrix[i].length - 1, target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] martix, int low, int high, int target) {
        System.out.println(martix[0]);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == martix[mid]) {
                return true;
            } else if (martix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
