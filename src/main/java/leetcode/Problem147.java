package leetcode;

/**
 * Created by Suheng on 3/4/16.
 */
public class Problem147 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ListNode head = initNode(nums);
        printNode(head);
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