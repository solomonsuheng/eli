package crackbook;

/**
 * Created by Suheng on 12/12/15.
 */
public class Stack<T> {
    Node<T> top;

    //判断栈是否为空
    public boolean isEmpty() {
        return this.top == null;
    }

    public String toString() {
        Node<T> temp = this.top;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (temp != null) {
            sb.append(temp.element + " ");
            temp = temp.next;
        }
        sb.append("]");

        return sb.toString();
    }

    //从栈弹出
    T pop() {
        if (top != null) {
            T data = this.top.element;
            top = top.next;
            return data;
        }
        return null;
    }

    //将数据压入到栈中
    void push(T element) {
        Node<T> t = new Node(element);
        t.next = top;
        top = t;
    }

    //获取栈顶元素,但是不弹出该元素
    T peek() {
        return this.top.element;
    }
}

