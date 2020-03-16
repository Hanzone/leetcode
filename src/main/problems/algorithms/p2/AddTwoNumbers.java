package problems.algorithms.p2;

import utils.ListNode;

import static utils.PrintUtils.print;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        print(new AddTwoNumbers().addTwoNumbers(l1, l2));

    }

}