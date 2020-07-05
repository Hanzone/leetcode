package problems.algorithms.p138;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that
 * each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 * or null if it does not point to any node.
 *
 *
 * Example 1: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e1.png</link>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e2.png</link>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e3.png</link>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 *
 *
 * Constraints:
 *
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * Number of Nodes will not exceed 1000.
 *
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        // construct a map
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.index, curr.val));
            curr = curr.next;
        }

        // link the pointerss
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        case1(copyListWithRandomPointer);
        case2(copyListWithRandomPointer);
        case3(copyListWithRandomPointer);
        case4(copyListWithRandomPointer);
    }

    /**
     * Example 1: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e1.png</link>
     * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     */
    private static void case1(CopyListWithRandomPointer copyListWithRandomPointer) {
        RandomListNode node0 = new RandomListNode(0, 7);
        RandomListNode node1 = new RandomListNode(1, 13);
        RandomListNode node2 = new RandomListNode(2, 11);
        RandomListNode node3 = new RandomListNode(3, 10);
        RandomListNode node4 = new RandomListNode(4, 1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        RandomListNode randomListNode = copyListWithRandomPointer.copyRandomList(node0);
        if (randomListNode == node0) {
            throw new RuntimeException("no copy");
        }
        print(randomListNode);
    }

    /**
     * Example 2: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e2.png</link>
     * Input: head = [[1,1],[2,1]]
     * Output: [[1,1],[2,1]]
     */
    private static void case2(CopyListWithRandomPointer copyListWithRandomPointer) {
        RandomListNode node0 = new RandomListNode(0, 1);
        RandomListNode node1 = new RandomListNode(1, 2);

        node0.next = node1;

        node0.random = node1;
        node1.random = node1;

        RandomListNode randomListNode = copyListWithRandomPointer.copyRandomList(node0);
        if (randomListNode == node0) {
            throw new RuntimeException("no copy");
        }
        print(randomListNode);
    }

    /**
     * Example 3: @see <link>https://assets.leetcode.com/uploads/2019/12/18/e3.png</link>
     * Input: head = [[3,null],[3,0],[3,null]]
     * Output: [[3,null],[3,0],[3,null]]
     */
    private static void case3(CopyListWithRandomPointer copyListWithRandomPointer) {
        RandomListNode node0 = new RandomListNode(0, 3);
        RandomListNode node1 = new RandomListNode(1, 3);
        RandomListNode node2 = new RandomListNode(2, 3);

        node0.next = node1;
        node1.next = node2;

        node0.random = null;
        node1.random = node0;
        node2.random = null;

        RandomListNode randomListNode = copyListWithRandomPointer.copyRandomList(node0);
        if (randomListNode == node0) {
            throw new RuntimeException("no copy");
        }
        print(randomListNode);
    }

    /**
     * Example 4:
     * Input: head = []
     * Output: []
     */
    private static void case4(CopyListWithRandomPointer copyListWithRandomPointer) {
        RandomListNode node0 = null;

        RandomListNode randomListNode = copyListWithRandomPointer.copyRandomList(node0);
        print(randomListNode);
    }

    private static void print(RandomListNode node) {
        System.out.print("[");
        printRandomListNode(node);
        System.out.println("]");
    }

    private static void printRandomListNode(RandomListNode node) {
        if (node == null) {
            return;
        }

        System.out.print("[" + node.val + ", " + (node.random == null ? "null" : node.random.index) + "]");
        printRandomListNode(node.next);
    }

    private static class RandomListNode {
        public int index;
        public int val;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int index, int val) {
            this.index = index;
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
