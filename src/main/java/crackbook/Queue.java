package crackbook;

/**
 * Created by Suheng on 12/12/15.
 */
public class Queue<T> {
    Node<T> first, last;

    //将数据加入队列
    void enqueue(T element) {
        if (this.first == null) {
            this.first = this.last = new Node(element);
        } else {
            this.last.next = new Node(element);
            this.last = this.last.next;
        }
    }

    //将队列从队头弹出
    T dequeue() {
        if (this.first != null) {
            T item = this.first.element;
            this.first = this.first.next;
            return item;
        }
        return null;
    }
}
