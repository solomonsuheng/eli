package eli;

/**
 * Created by Suheng on 12/9/15.
 */
public class Node<T> {
    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
    }
}
