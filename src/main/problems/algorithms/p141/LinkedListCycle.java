package problems.algorithms.p141;

import utils.ListNode;

import static utils.PrintUtils.print;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (true) {
            // if there is no cycle, there is an end
            if (fast == null || fast.next == null) {
                return false;
            }
            // if there is no cycle, fast will catch end in cycle
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle test = new LinkedListCycle();

        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = node1.next;
        print(test.hasCycle(node1));

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = node2;
        print(test.hasCycle(node2));

        ListNode node3 = new ListNode(1);
        print(test.hasCycle(node3));
    }

}
