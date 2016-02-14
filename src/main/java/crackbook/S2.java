package crackbook;

/**
 * Created by Suheng on 12/10/15.
 */
public class S2 {
    public static void main(String[] args) {
        String s = " *(abcd,. qw e";

    }

    public static int[][] deleteAll(int[][] matrix, int n, int m) {
        int row = -1;
        int col = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }

        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }

        return matrix;
    }

    //test the matrixTran90
    public static void test() {
        int[][] martix0 = {{1, 2}, {3, 4}};
        int[][] martix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] martix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] martix3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printMatrix(martix3);
        System.out.println();
        transform90(martix3, 5);
        printMatrix(martix3);
    }


    public static void printMatrix(int[][] martrix) {
        for (int i = 0; i < martrix.length; i++) {
            for (int j = 0; j < martrix.length; j++) {
                System.out.print(martrix[i][j] + " \t");
            }
            System.out.println();
        }
    }

    public static int[][] transform90(int[][] martix, int n) {
        int offset = 0;
        for (int i = 0; i < n / 2; i++, offset++) {
            int last = n - 1 - i;
            for (int j = i; j < last; j++) {
                int temp = martix[i][j];
                //左面的换到上面
                martix[i][j] = martix[last - j + offset][i];
                //下面换到左面
                martix[last - j + offset][i] = martix[last][last - j + offset];
                //右面换到下面
                martix[last][last - j + offset] = martix[j][last];
                //上面换到右面
                martix[j][last] = temp;
            }
        }


        return martix;
    }

    public static String compres(char[] charArray) {
        int[] nums = new int[256];
        for (int i = 0; i < charArray.length; i++) {
            nums[charArray[i]]++;
        }

        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                flag = true;
                break;
            }
        }

        if (flag) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < charArray.length; i++) {
                if (nums[charArray[i]] > 0) {
                    sb.append(charArray[i]);
                    sb.append(nums[charArray[i]]);
                    nums[charArray[i]] = 0;
                }
            }
            return sb.toString();
        } else {
            return new String(charArray);
        }
    }

    public static void replaceTheSpace(char[] charArray) {
        int length = charArray.length;
        int countOfSpace = 0;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                countOfSpace++;
            }
        }
        //计算出空格的个数重新申请数组的大小
        char[] newCA = new char[3 * countOfSpace + charArray.length - countOfSpace];
        for (int i = 0, j = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                newCA[j++] = '%';
                newCA[j++] = '2';
                newCA[j++] = '0';
            } else {
                newCA[j++] = charArray[i];
            }
        }
        for (char c : newCA) {
            System.out.print(c);
        }

    }

    public static boolean isRenewIsSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] numChar1 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            numChar1[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (--numChar1[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void reverseString(char[] cc) {
        for (int i = 0, j = cc.length - 1; i < j; i++,
                j--) {
            char tempC = cc[i];
            cc[i] = cc[j];
            cc[j] = tempC;
        }
        for (char c : cc) {
            System.out.print(c);
        }
    }

    public static boolean isAllDifferent(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] is = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (is[s.charAt(i)]) {
                return false;
            } else {
                is[s.charAt(i)] = true;
            }
        }

        return true;
    }
}
