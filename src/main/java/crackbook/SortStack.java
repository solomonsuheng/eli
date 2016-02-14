package crackbook;

/**
 * Created by Suheng on 12/16/15.
 */
public class SortStack {
    public static void main(String[] args) {
        //有两个栈,其中一个排好序,另一个没有排好序
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        stack1.push(5);
        stack1.push(10);
        stack1.push(17);

        stack2.push(12);
        stack2.push(8);
        stack2.push(3);
        stack2.push(1);

        sort(stack1, stack2);
        System.out.println(stack2);
    }

    private static void sort(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            while (!stack2.isEmpty() && temp > stack2.peek()) {
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }
    }
}
