package leetcode;

/**
 * Created by Suheng on 3/4/16.
 */
public class Problem147 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ListNode head = initNode(nums);
        printNode(head);
        System.out.println(isCircle(head));
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
