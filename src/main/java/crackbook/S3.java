package crackbook;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Suheng on 12/10/15.
 */
public class S3 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {9, 4, 1, 1, 4, 9};

        System.out.println(isPaListNode(initNode(nums2)));
    }

    public static boolean isPaListNode(Node<Integer> head) {
        if (head == null && head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();

        Node<Integer> slow = head;
        Node<Integer> fast = head;
        boolean flag = true;
        while (fast != null) {
            stack.push(slow.element);
            if (fast.next == null) {
                //是奇数
                flag = false;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if (flag) {
            //偶数
        } else {
            //奇数
            slow = slow.next;
            stack.pop();
        }


        while (slow != null) {
            if (slow.element.intValue() != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;

    }


    public static boolean isCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;
        boolean flag = true;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            if (flag) {
                slow = slow.next;
                flag = false;

            } else {
                flag = true;
            }
            fast = fast.next;
        }

        return false;
    }

    public static Node<Integer> findTHeCircleEnterNode(Node<Integer> head) {
        if (!isCircle(head)) {
            return null;
        }

        Node slowPointer = head;
        Node fastPointer = head.next;

        boolean flag = true;
        while (fastPointer != slowPointer) {
            if (flag) {
                flag = false;
            } else {
                slowPointer = slowPointer.next;
                flag = true;
            }

            fastPointer = fastPointer.next;
        }

        fastPointer = head;
        System.out.println(slowPointer.element);
        return slowPointer;
    }

    public static Node<Integer> addTwoListOrderNode(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null & head2 != null) {
            return head2;
        } else if (head2 == null && head1 != null) {
            return head1;
        } else if (head1 == null && head2 == null) {
            return null;
        }


        int num1 = 0;
        int num2 = 0;

        Node<Integer> tp1 = head1;
        Node<Integer> tp2 = head2;

        while (tp1 != null) {
            num1 = num1 * 10 + tp1.element;
            tp1 = tp1.next;
        }

        while (tp2 != null) {
            num2 = num2 * 10 + tp2.element;
            tp2 = tp2.next;
        }

        System.out.println(num1 + num2);

        int sum = num1 + num2;
        Node<Integer> resultNode = new Node<Integer>(-1);
        while (sum > 0) {
            int temp = sum % 10;
            sum /= 10;

            Node<Integer> tempNode = new Node<Integer>(temp);
            tempNode.next = resultNode.next;
            resultNode.next = tempNode;
        }
        return resultNode.next;
    }


    public static Node addTwoNodeList(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null && head2 != null) {
            return head2;
        } else if (head2 == null && head1 != null) {
            return head1;
        } else if (head1 == null && head2 == null) {
            return null;
        }
        Node<Integer> resultNodeList = new Node<Integer>(-1);
        Node<Integer> temp = resultNodeList;
        Node<Integer> tempNode1 = head1;
        Node<Integer> tempNode2 = head2;


        int step = 0;
        while (tempNode1 != null && tempNode2 != null) {
            int sum = (tempNode1.element + tempNode2.element + step);
            step = sum / 10;
            sum %= 10;
            Node<Integer> tt = new Node<Integer>(sum);
            temp.next = tt;
            temp = temp.next;
            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;
        }

        Node<Integer> tempNodeh = null;
        if (tempNode1 != null) {
            tempNodeh = tempNode1;
        } else if (tempNode2 != null) {
            tempNodeh = tempNode2;
        }

        while (tempNodeh != null) {
            int sum = (tempNodeh.element + step);
            step = sum / 10;
            sum %= 10;
            Node<Integer> tt = new Node<Integer>(sum);
            temp.next = tt;
            temp = temp.next;
            tempNodeh = tempNodeh.next;
        }

        if (step > 0) {
            Node<Integer> tt = new Node<Integer>(step);
            temp.next = tt;
            temp = temp.next;
        }
        printNodeInOrder(resultNodeList);
        return resultNodeList;
    }

    public static Node<Integer> partitionListNode(Node<Integer> head, int x) {
        if (head == null) {
            return null;
        }

        Node<Integer> beforeHead = new Node(-1);
        Node<Integer> before = beforeHead;
        Node<Integer> afterHead = new Node(-1);
        Node<Integer> after = afterHead;

        while (head != null) {
            if (head.element < x) {
                before.next = head;
                head = head.next;
                before = before.next;
                before.next = null;
            } else {
                after.next = head;
                head = head.next;
                after = after.next;
                after.next = null;
            }
        }

        before.next = afterHead.next;
        return beforeHead.next;
    }


    public static void removeNode(Node head) {
        Node pDeleNode = head;
        for (int i = 1; i < 4; i++) {
            pDeleNode = pDeleNode.next;
        }

        printNodeInOrder(head);
        pDeleNode.element = pDeleNode.next.element;
        pDeleNode.next = pDeleNode.next.next;
        printNodeInOrder(head);
    }

    public static int findTheKthNodeRec(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int i = findTheKthNodeRec(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.element);
        }
        return i;

    }

    public static Node findTheKthNode(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        Node pFast = head;
        for (int i = 0; i < k; i++) {
            pFast = pFast.next;
        }

        Node pSlow = head;
        while (pFast != null) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }

        return pSlow;
    }

    public static Node removeDuplicate(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> pCount = head;
        Node<Integer> pPre = head;
        Node<Integer> pNext = head.next;

        while (pCount != null) {
            while (pNext != null) {
                if (pNext.element == pCount.element) {
                    pPre.next = pNext.next;
                    pNext = pNext.next;
                } else {
                    pPre = pPre.next;
                    pNext = pNext.next;
                }
            }
            pCount = pCount.next;
            pPre = pCount;
            if (pPre == null) {
                break;
            }
            pNext = pPre;
        }

        return head;
    }

    public static Node removeDuplicateNodeWithHashSet(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> hs = new HashSet<Integer>();

        Node<Integer> pPre = head;
        Node<Integer> pNext = head.next;
        hs.add(pPre.element);
        while (pNext != null) {
            if (hs.contains(pNext.element)) {
                pPre.next = pNext.next;
            } else {
                hs.add(pNext.element);
                pPre = pPre.next;
            }
            pNext = pNext.next;
        }
        return head;
    }

    public static void printNodeDisOrder(Node head) {
        if (head.next != null) {
            printNodeDisOrder(head.next);
        }

        System.out.print(head.element + "->");
    }

    public static void printNodeInOrder(Node head) {
        Node pTemp = head;
        while (pTemp != null) {
            System.out.print(pTemp.element + "->");
            pTemp = pTemp.next;
        }

        System.out.println("null");
    }

    public static Node<Integer> initNode(int... nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        head.next = null;
        Node pHead = head;

        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            pHead.next = temp;
            temp.next = null;
            pHead = pHead.next;
        }

        return head;
    }

}
