package eli;

/**
 * Created by Suheng on 12/9/15.
 */
public class S1 {
    public static void main(String[] args) {
        //根据数组来进行链表的构建
        int[] nums = {10, 5, 12, 4, 7};
        Node<Integer> head = initNode(nums);
    }


    public static boolean deleteNode(Node head, Node toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return false;
        }

        if (toBeDeleted.next == null) {
            Node temp = head;
            while (temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
            return true;
        }

        toBeDeleted.element = toBeDeleted.next.element;
        toBeDeleted.next = toBeDeleted.next.next;

        return true;
    }


    //find the first enter of the circle
    public static Node firstCircleEnter(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (!isCircle(head)) {
            return null;
        }

        Node slowPointer = head;
        Node fastPointer = head.next;


        boolean step = true;
        while (fastPointer != slowPointer) {
            if (step) {
                slowPointer = slowPointer.next;
                step = false;
            } else {
                step = true;
            }
            fastPointer = fastPointer.next;
        }

        fastPointer = head;
        while (fastPointer != slowPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer;
    }

    //find the two intersect list first node
    public static Node findTheFirstNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        if (!isIntersect(head1, head2)) {
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;
        int count1 = countTheNumberOfListNode(head1);
        int count2 = countTheNumberOfListNode(head2);
        if (count1 > count2) {
            for (int i = 0; i < (count1 - count2); i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i = 0; i < (count2 - count1); i++) {
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            if (temp1 == temp2) {
                return temp1;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return null;
    }

    //judge two list node is intersect
    public static boolean isIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        return temp1 == temp2;
    }

    public static Node[] sameTailListNode() {
        Node node11 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        Node node14 = new Node(4);
        Node node15 = new Node(5);

        Node node21 = new Node(10);
        Node node22 = new Node(11);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        node21.next = node22;
        node22.next = node14;

        Node[] node = {node11, node21};
        return node;
    }

    //create a cicrleList
    public static Node createCicleList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node5;

        return node1;
    }

    public static boolean isCircle(Node head) {
        if (head == null) {
            return false;
        }


        Node slowPointer = head;
        Node fastPointer = head;
        boolean step = true;
        while (fastPointer != null) {
            if (step) {
                step = false;
            } else {
                slowPointer = slowPointer.next;
                step = true;
            }
            fastPointer = fastPointer.next;

            if (fastPointer == slowPointer) {
                return true;
            }
        }

        return false;
    }

    //merge 2 order list
    public static Node mergeOrderListNode(Node<Integer> h1, Node<Integer> h2) {
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }

        Node h3 = null;
        if (h1.element > h2.element) {
            h3 = h2;
            h2 = h2.next;
        } else {
            h3 = h1;
            h1 = h1.next;
        }

        Node head = h3;

        while (h1 != null && h2 != null) {
            if (h1.element > h2.element) {
                h3.next = h2;
                h2 = h2.next;
                h3 = h3.next;
            } else {
                h3.next = h1;
                h1 = h1.next;
                h3 = h3.next;
            }
        }

        if (h1 != null) {
            h3.next = h1;
        }
        if (h2 != null) {
            h3.next = h2;
        }

        return head;
    }

    //print the node in disorder
    public static void printReverseNode(Node head) {
        if (head.next != null) {
            printReverseNode(head.next);
        }
        System.out.print(head.element + "->");
    }

    //find the mid node
    public static Node findTheMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        Node temp1 = head;
        Node temp2 = head.next;


        boolean flag = true;
        while (temp2 != null) {
            temp2 = temp2.next;
            if (!flag) {
                temp1 = temp1.next;
                flag = true;
            } else {
                flag = false;
            }
        }

        return temp1;
    }

    //find the kth node
    public static Node findkthNode(Node head, int kth) {
        if (head == null || kth < 1) {
            return head;
        }

        Node temp = head;
        for (int i = 0; i < kth; i++) {
            temp = temp.next;
        }

        Node temp2 = head;
        while (temp != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }


        return temp2;
    }


    //reverse the list node
    public static Node<Integer> reverseTheListNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node tempP = head.next;
        head.next = null;
        while (tempP != null) {
            Node temp = tempP;
            tempP = tempP.next;
            temp.next = head;
            head = temp;
        }

        return head;
    }

    //count the number of the ListNode
    public static int countTheNumberOfListNode(Node head) {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //print list node with order
    public static void printNodeInOrder(Node<Integer> node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.element + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static Node<Integer> initNode(int... nums) {
        //尾部插入
        if (nums.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<Integer>(nums[0]);
        Node<Integer> cursorPointer = head;
        for (int i = 1; i < nums.length; i++) {
            Node<Integer> tempNode = new Node<Integer>(nums[i]);
            tempNode.next = null;
            cursorPointer.next = tempNode;
            cursorPointer = cursorPointer.next;
        }

        return head;
    }
}
