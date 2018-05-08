package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/26
 * Time: 09:23
 * Description:
 */
public class B11169 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(7);
//        ListNode node5 = new ListNode(9);

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(6);
//        ListNode node9 = new ListNode(8);
//        ListNode node10 = new ListNode(10);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;

        ListNode merged = Merge(head1, head2);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode merged = new ListNode(-1);
        ListNode point = merged;
        while (p != null && q != null) {
            if (p.val < q.val) {
                point.next = p;
                point = point.next;
                p = p.next;
            } else {
                point.next = q;
                point = point.next;
                q = q.next;
            }
        }

        if (q != null) {
            point.next = q;
        }

        if (p != null) {
            point.next = p;
        }

        return merged.next;
    }
}
