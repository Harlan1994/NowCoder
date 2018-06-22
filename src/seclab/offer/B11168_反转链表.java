package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 10:40
 * Description:
 */
public class B11168_反转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode q = head, p = q.next, s;
        q.next = null;
        while (p != null) {
//            q.next = p.next;
            s = p.next;
            p.next = q;
//            q.next = null;
            q = p;
            p = s;
        }
        return q;
    }

    public static void main(String[] args) {
        B11168_反转链表 b11168_反转链表 = new B11168_反转链表();
        ListNode listNode = new ListNode(-1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        ListNode listNode1 = b11168_反转链表.ReverseList(listNode);
        ListNode p = listNode1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
