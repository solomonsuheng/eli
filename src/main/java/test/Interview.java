package test;

/**
 * Created by Suheng on 12/21/15.
 */
public class Interview {
    public static void main(String[] args) throws Exception {
        getCount(6, 2, 1, 0, 0, 0, 1, 0, 0, 0);
    }

    //根据上排给出的10个数字
    public static void getCount(int... nums) {
        int[] count = new int[10];
        for (int i = 0; i < 10; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + "在下排出现了" + count[i] + "次");
        }

    }

    //查i找最小的k个元素
    public static void findTheKNumber(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //求子数组的最大和
    public static int findTheMaxSubArray(int... nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        if (maxSum == 0) {
            maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (maxSum < nums[i]) {
                    maxSum = nums[i];
                }
            }
        }
        return maxSum;
    }

    /**
     * (1,(2,3),(4,(5,6),7))
     */

    public static String format(String str) throws Exception {
        String[] cS = str.split(",");
        StringBuffer sb = new StringBuffer();
        for (String s : cS) {
            sb.append(s);
        }

        System.out.println(sb);
        String result = sb.toString();
        StringBuffer resultSb = new StringBuffer();
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '(') {
                stack.push('(');
            } else if (result.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    char temp = stack.pop();
                    if (temp != '(') {
                        throw new Exception("左右括号不匹配");
                    }
                } else {
                    throw new Exception("Error Expression");
                }
            } else {
                resultSb.append(result.charAt(i));
            }
        }
        for (int i = 1; i < resultSb.length(); i += 2) {
            resultSb.insert(i, ",");
        }
        resultSb.insert(0, "(");
        resultSb.append(")");

        System.out.println(resultSb);
        return "";
    }

    public static char[] reverse_str(char[] charArray) {
        if (charArray.length <= 1) {
            return charArray;
        }

        int start = 0;
        int end = charArray.length - 1;
        for (; start <= end; start++, end--) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
        }
        return charArray;
    }

}
