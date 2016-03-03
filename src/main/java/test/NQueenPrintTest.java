package test;

/**
 * Created by Suheng on 3/3/16.
 */
public class NQueenPrintTest {
    public static void main(String[] args) {
        NQueenPrint(8);
    }

    public static void NQueenPrint(int N) {
        int[] q = new int[N];
        NQueenPrint(q, 0);
    }

    private static void NQueenPrint(int[] q, int n) {
        int N = q.length;
        if (n == N) {
            print(q);
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isOk2(q, n)) {
                    NQueenPrint(q, n + 1);
                }
            }
        }

    }

    private static void print(int[] q) {
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    private static boolean isOk2(int[] q, int n) {

        for (int i = 0; i < n; i++) {
            int asd = 10;
            if (q[i] == q[n]) {
                return false;
            }
            if ((q[i] - q[n]) == (n - i)) {
                return false;
            }
            if ((q[n] - q[i]) == (n - i)) {
                return false;
            }
        }
        return true;
    }


}
