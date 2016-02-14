package crackbook;

/**
 * Created by Suheng on 12/22/15.
 */
public class TTClass {
    public static int n = 0;
    public static int sum = 0;
    public String s;

    public TTClass() {
        n++;
        System.out.println(n);
        sum += n;
    }

    public static int getSum() {
        return sum;
    }
}
