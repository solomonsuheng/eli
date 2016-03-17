package leetcode;

/**
 * Created by Suheng on 3/4/16.
 */
public class Problem147 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode head = initNode(nums);


        ListNode h1 = initNode(1, 2, 5, 7, 8, 10);
        ListNode h2 = initNode(3, 6, 7, 8, 12, 30);
        printNode(h1);
        printNode(h2);
        printNode(mergeTwoLists(h1, h2));
    }


    /**
     * Problem 21
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                cur.next = null;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                cur.next = null;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return result.next;
    }

    /**
     * Problem 61
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k < 0 || head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = head;

        k = k % (countSize(head));
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return reverseList(head);
            }
            cur = cur.next;
        }

        if (cur == null) {
            return head;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }


        cur.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }

    /**
     * 获取链表大小
     */
    public static int countSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;


        ListNode tmp = head;
        while (tmp != null) {
            count++;
            ;
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * Problem 234
     */

    public static boolean isPalindrome(ListNode head) {
        boolean flag = true;

        if (head == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null) {
            if (flag) {
                slowPointer = slowPointer.next;
                flag = false;
            } else {
                flag = true;
            }
            fastPointer = fastPointer.next;
        }


        //fastPointer point to the end
        //reverse slowpointer
        //set fastPointer to the head
        fastPointer = head;
        printNode(slowPointer);
        slowPointer = reverseList(slowPointer);
        printNode(slowPointer);
        flag = true;
        while (slowPointer != null) {
            if (fastPointer.val != slowPointer.val) {
                System.out.println(slowPointer.val + " " + fastPointer.val);
                flag = false;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return flag;
    }

    /**
     * reverse listnode
     */

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //create a tmp head to point the head
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode cur = head;

        while (cur.next != null) {
            tmpHead.next = cur.next;
            cur.next = cur.next.next;
            tmpHead.next.next = cur;
            cur = cur.next;
        }

        return tmpHead.next;
    }


    /**
     * Problem 206
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpHead = new ListNode(-1);

        printNode(head);

        while (head != null) {
            ListNode cur = head.next;
            head.next = tmpHead.next;
            tmpHead.next = head;
            head = cur;
        }
        return tmpHead.next;
    }

    /**
     * Problem 237
     */
    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;

        node.next = node.next.next;

    }

    /**
     * Problem 203
     */

    public static ListNode removeElement(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;

        ListNode cur = tmpHead.next;
        ListNode pre = tmpHead;

        while (cur != null) {
            boolean flag = true;
            if (cur.val == val) {
                flag = false;
                pre.next = cur.next;
            }

            if (flag) {
                pre = pre.next;
            }

            cur = cur.next;
        }
        return tmpHead.next;

    }

    /**
     * Problem 142
     */
    public static ListNode detectCycle(ListNode head) {
        if (!isCircle(head)) {
            return null;
        }
        ListNode tmpSlow = head.next;
        ListNode tmpFast = head.next.next;

        while (tmpSlow != tmpFast) {
            tmpFast = tmpFast.next.next;
            tmpSlow = tmpSlow.next;
        }
        tmpSlow = head;
        while (tmpSlow != tmpFast) {
            tmpFast = tmpFast.next;
            tmpSlow = tmpSlow.next;
        }

        return tmpFast;

    }

    public static boolean isCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode tmpSlow = head;
        ListNode tmpFast = head.next;
        boolean flag = true;
        while (tmpSlow != tmpFast && tmpFast != null) {
            if (flag) {
                tmpFast = tmpFast.next;
                tmpSlow = tmpSlow.next;
                flag = false;
            } else {
                tmpFast = tmpFast.next;
                flag = true;
            }
        }
        if (tmpFast != null) {
            return true;
        } else {
            return false;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head.next;

        head.next = null;
        ListNode headpointer = head;
        while (pointer != null) {
            ListNode tmp = pointer;
            pointer = pointer.next;

            while (headpointer.next != null) {
                if (tmp.val > headpointer.val) {
                    headpointer = headpointer.next;
                } else {
                    headpointer.next = tmp;
                    int tt = headpointer.val;
                    headpointer.val = tmp.val;
                    tmp.val = tt;
                }
            }
            if (headpointer.val < tmp.val) {
                headpointer.next = tmp;
            }


        }

        return head;
    }

    public static void reverPrintNode(ListNode head) {
        if (head.next != null) {
            reverPrintNode(head.next);
        }
        System.out.print(head.val + "->");
    }

    public static void printNode(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    public static ListNode initNode(int... nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode tmpPointer = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            tmpPointer.next = tmp;
            tmpPointer = tmpPointer.next;
        }

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
