package crackbook;

/**
 * Created by Suheng on 12/23/15.
 */
public class FindTheFirstChar {
    public static void main(String[] args) {

        firstFind("iabccdeff");
    }

    public static void firstFind(String str) {
        char[] ca = str.toCharArray();
        int[] cac = new int[256];

        for (int i = 0; i < ca.length; i++) {
            cac[ca[i]]++;
        }

        for (int i = 0; i < ca.length; i++) {
            if(cac[ca[i]]==1){
                System.out.print(ca[i]);
                break;
            }
        }


    }

}
