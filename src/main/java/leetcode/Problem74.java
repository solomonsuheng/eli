package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 5));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 0 || matrix[0].length < 1) {
            return false;
        }


        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if ((target <= matrix[i][col - 1])) {
                int low = 0;
                int high = matrix[i].length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (target == matrix[i][mid]) {
                        return true;
                    } else if (target < matrix[i][mid]) {
                        high = mid - 1;
                    } else if (target > matrix[i][mid]) {
                        low = mid + 1;
                    }
                }
            }
        }

        return false;
    }

}
