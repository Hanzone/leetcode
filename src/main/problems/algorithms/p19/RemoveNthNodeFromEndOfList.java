package problems.algorithms.p19;

import utils.ListNode;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = n == 1 ? head : null;
        ListNode dummy = null;

        while (fast.next != null) {
            fast = fast.next;

            if (slow == null) {
                if (--n == 1) {
                    slow = head;
                }
            } else {
                dummy = slow;
                slow = slow.next;
            }
        }

        if (dummy == null) {
            return head.next;
        }
        dummy.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode expect = new ListNode(1);
        expect.next = new ListNode(2);
        expect.next.next = new ListNode(3);
        expect.next.next.next = new ListNode(5);

        ListNode answer = removeNthNodeFromEndOfList.removeNthFromEnd(root, 2);
        printAnswerAndExpect(answer, expect);
    }

}
