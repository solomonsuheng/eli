package daily;

/**
 * Created by Suheng on 3/3/16.
 */
public class Queens {
    /**
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     */

    public static int number = 0;

    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            //same column
            if (q[i] == q[n]) {
                return false;
            }
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }

    public static void printQueens(int[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N) {
            printQueens(q);
            number++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n)) enumerate(q, n + 1);
            }
        }
    }


    public static void main(String[] args) {

        enumerate(1);
        System.out.println(number);
    }
}
