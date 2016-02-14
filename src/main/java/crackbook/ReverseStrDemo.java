package crackbook;

/**
 * Created by Suheng on 12/22/15.
 */
public class ReverseStrDemo {
    public static void main(String[] args) {
        String senctence = "I am a student.";
        reverseString(senctence);
    }


    //首先对整个句子进行翻转
    //然后对每个单词进行翻转
    public static void reverseString(String str) {
        char[] ca = str.toCharArray();

        //对整个句子进行翻转
        reverse(ca, 0, ca.length - 1);


        int word = 0;
        //对单词进行翻转
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == ' ') {
                reverse(ca, word, i - 1);
                word = i + 1;
            }
        }


        System.out.println(new String(ca));
    }


    private static void reverse(char[] ca, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            swap(ca, i, j);
        }
    }

    private static void swap(char[] ca, int i, int j) {
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }

}
