package problems.algorithms.p142;

import utils.ListNode;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1: @see <link>https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png</link>
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2: @see <link>https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png</link>
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3: @see <link>https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png</link>
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            // if there is no cycle, there is an end
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            // if there is a cycle, fast will catch slow in cycle
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListCycleII test = new LinkedListCycleII();

        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = node1.next;
        ListNode detectedNode1 = test.detectCycle(node1);
        printAnswerAndExpect(node1.next.val, detectedNode1 == null ? null : detectedNode1.val);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = node2;
        ListNode detectedNode2 = test.detectCycle(node2);
        printAnswerAndExpect(node2.val, detectedNode2 == null ? null : detectedNode2.val);

        ListNode node3 = new ListNode(1);
        ListNode detectedNode3 = test.detectCycle(node3);
        printAnswerAndExpect(null, detectedNode3 == null ? null : detectedNode3.val);
    }

}
