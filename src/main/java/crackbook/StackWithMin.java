package crackbook;

/**
 * Created by Suheng on 12/15/15.
 */
//设计一个栈,除了pop和push方法,还支持min方法,可返回栈元素中的最小值
//pop,push,min三个方法的时间复杂度必须为O(1)
public class StackWithMin {
    Node<Integer> top = null;
    int min = Integer.MAX_VALUE;

    boolean push(Integer element) {
        if (element < min) {
            this.min = element;
        }
        Node<Integer> temp = new Node<Integer>(element);
        temp.next = top;
        top = temp;

        return true;
    }

    Integer pop() {
        if (top == null) {
            return null;
        }

        int popElement = this.top.element;
        this.top = this.top.next;

        return popElement;
    }


    public String toString() {
        Node<Integer> temp = this.top;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (temp != null) {
            sb.append(temp.element + " ");
            temp = temp.next;
        }
        sb.append("]");

        sb.append("\nThe min of the stack is : " + this.getMin());
        return sb.toString();
    }

    public static void main(String[] args) {
        StackWithMin stt = new StackWithMin();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 10);
            stt.push(random);
        }

        System.out.println(stt);
    }

    int getMin() {
        return this.min;
    }
}
