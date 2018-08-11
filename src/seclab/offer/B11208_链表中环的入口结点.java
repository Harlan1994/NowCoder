package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/17
 * Time: 21:54
 * Description:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class B11208_链表中环的入口结点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = listNode.next.next;

        ListNode loopEntry = EntryNodeOfLoop(listNode);
        System.out.println(loopEntry.val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) return null;

        // 设立快慢指针
        ListNode slowerNode = pHead.next;
        if (slowerNode == null) {
            return null;
        }

        ListNode fasterNode = slowerNode.next;

        boolean circleExist = false;
        int circleCount = 0;

        // 先确认是否有环
        while (fasterNode != null && fasterNode.next != null) {
            if (slowerNode.val == fasterNode.val) {
                // 找到环
                circleExist = true;
                ListNode tmp = slowerNode.next;
                circleCount = 1;
                while (tmp.val != slowerNode.val) {
                    circleCount++;
                    tmp = tmp.next;
                }
                break;
            } else {
                slowerNode = slowerNode.next;
                fasterNode = fasterNode.next.next;
            }
        }

        // 如果没有环
        if (!circleExist) {
            return null;
        }

        // 有环
        slowerNode = fasterNode = pHead;

        // 其中一个先走circleCount步
        int count = circleCount;
        while (count != 0) {
            count--;
            slowerNode = slowerNode.next;
        }

        while (slowerNode.val != fasterNode.val) {
            slowerNode = slowerNode.next;
            fasterNode = fasterNode.next;
        }

        return slowerNode;
    }
}
