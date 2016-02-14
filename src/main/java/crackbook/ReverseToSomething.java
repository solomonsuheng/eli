package crackbook;

/**
 * Created by Suheng on 12/24/15.
 */
public class ReverseToSomething {
    public static void main(String[] args) {

    }

    public static void printNode(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.element + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    //根据给的数组进行链表的初始化
    public static Node<Integer> initNode(int... nums) {
        if (nums.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<Integer>(nums[0]);
        Node<Integer> pointer = head;

        for (int i = 1; i < nums.length; i++) {
            Node<Integer> temp = new Node<Integer>(nums[i]);
            pointer.next = temp;
            pointer = pointer.next;
        }

        return head;
    }

    //单链表就地逆置

}
