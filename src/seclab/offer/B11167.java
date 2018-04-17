package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/17
 * Time: 13:44
 * Description:
 */
public class B11167 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = FindKthToTail(head, 3);
        System.out.println(node.val);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head, q = p;

        while (k > 0 && p != null) {
            p = p.next;
            k--;
        }

        if(k > 0) return null; // 防止k越界

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
