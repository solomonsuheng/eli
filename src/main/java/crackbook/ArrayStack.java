package crackbook;

/**
 * Created by Suheng on 12/15/15.
 */
//只用一个数组来实现三个栈
public class ArrayStack {
    int[] numsArray = new int[12];
    int index = 4;
    //第一个栈由数组0开始到第二数组结束为止
    int st1 = 0;
    int st2 = index;
    int st3 = numsArray.length - 1;


    //向第一个栈中添加数据
    boolean pushTost1(int element) {
        if (st1 == index) {
            return false;
        }
        numsArray[st1++] = element;

        return true;
    }

    //从第一个栈中弹出元素
    int popFromst1() {
        if (st1 == 0) {
            return -1;
        } else {
            return numsArray[--st1];
        }
    }

    //向第二个栈中添加元素
    boolean pushTost2(int element) {
        if (st2 != st3) {
            numsArray[st2++] = element;
            return true;
        }
        return false;
    }


    //从第二栈中弹出元素
    int popFromst2() {
        if (st2 == index) {
            return -1;
        } else {
            return numsArray[--st2];
        }
    }



    public static void main(String[] args) {
        ArrayStack s1 = new ArrayStack();
        for (int i = 0; i < 10; i++) {
            System.out.println(s1.pushTost2(i));
        }
    }
}
