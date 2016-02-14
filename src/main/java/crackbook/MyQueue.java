package crackbook;

/**
 * Created by Suheng on 12/15/15.
 */
//实现一个MyQueue类,该类用两个栈来实现一个队列
public class MyQueue<T> {
    //使用两个栈来实现一个队列
    Stack<T> st1 = new Stack<T>();
    Stack<T> st2 = new Stack<T>();

    void enqueue(T element) {
        st1.push(element);
    }

    T dequeue() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        if (!st2.isEmpty()) {
            return st2.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
