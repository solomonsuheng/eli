package leetcode;

/**
 * Created by Suheng on 3/3/16.
 */
public class Problem52 {
    public static void main(String[] args) {
        totalNQueens(1);
    }

    private static void totalNQueens(int N) {
        int[] q = new int[N];
        totalNQueens(q, 0);
        System.out.println(number);
    }

    public static int number = 0;

    private static void totalNQueens(int[] q, int N) {
        int l = q.length;
        if (l == N) {
            number++;
        } else {
            for (int i = 0; i < l; i++) {
                q[N] = i;
                if (isConsistent(q, N)) {
                    totalNQueens(q, N + 1);
                }
            }
        }
    }

    public static boolean isConsistent(int[] q, int N) {
        for (int i = 0; i < N; i++) {
            if (q[i] == q[N]) {
                return false;
            }
            if ((q[i] - q[N]) == (N - i)) {
                return false;
            }
            if ((q[N] - q[i]) == (N - i)) {
                return false;
            }
        }
        return true;
    }
}
