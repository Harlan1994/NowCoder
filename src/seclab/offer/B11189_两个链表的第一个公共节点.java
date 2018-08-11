package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/7
 * Time: 14:25
 * Description:
 */
public class B11189_两个链表的第一个公共节点 {

    public static void main(String[] args) {
        B11189_两个链表的第一个公共节点 b11189_两个链表的第一个公共节点 = new B11189_两个链表的第一个公共节点();
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 计算两个链表的长度
        int length1 = 0;
        int length2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                length1++;
                node1 = node1.next;
            }
            if (node2 != null) {
                length2++;
                node2 = node2.next;
            }
        }

        node1 = pHead1;
        node2 = pHead2;

        int diff = Math.abs(length1 - length2);
        if (length1 > length2) {
            while (diff-- > 0) {
                node1 = node1.next;
            }
        } else if (length1 < length2) {
            while (diff-- > 0) {
                node2 = node2.next;
            }
        }

        // 一起走，走到相同的即可
        while (node1 != null) {
            if (node1.val == node2.val) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }
}
