package seclab.leetcode;


/**
 * judge if a list contains a circle.
 */
public class L29039 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
