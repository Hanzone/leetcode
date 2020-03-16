package problems.algorithms.p445;

import utils.ListNode;

import java.util.Stack;

import static utils.PrintUtils.print;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // store data in stack
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        ListNode current = l1;
        while (current != null) {
            l1Stack.push(current.val);
            current = current.next;
        }
        current = l2;
        while (current != null) {
            l2Stack.push(current.val);
            current = current.next;
        }

        // pop and cal
        int carry = 0;
        ListNode result = null;
        while (!l1Stack.empty() || !l2Stack.empty()) {
            int l1Val = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int l2Val = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        print(new AddTwoNumbersII().addTwoNumbers(l1, l2));
    }
}
