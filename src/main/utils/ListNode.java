package utils;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(val));
        ListNode p = next;
        while (p != null) {
            sb.append("->").append(p.val);
            p = p.next;
        }
        return sb.toString();
    }

}
