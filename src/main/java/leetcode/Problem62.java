package leetcode;

/**
 * Created by Suheng on 2/25/16.
 */
public class Problem62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (x == 0 || y == 0) {
                    matrix[y][x] = 1;
                } else {
                    matrix[y][x] = matrix[y - 1][x] + matrix[y][x - 1];
                }
            }
        }
        return matrix[n - 1][m - 1];
    }
}
