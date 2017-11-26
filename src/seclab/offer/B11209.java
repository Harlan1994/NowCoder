package seclab.offer;

import java.util.List;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/3
 * Time: 10:08
 * Description:
 */
public class B11209 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] nums = data.split(" ");
            for (int i = 0; i < nums.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(nums[i]));
                p.next = temp;
                p = p.next;
            }
            ListNode head = new B11209().deleteDuplication(root);
            System.out.println("Oh, shit");
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode root = new ListNode(-1);// 手动添加头结点
        root.next = pHead;
        ListNode p = root.next, q = root;

        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                while (p.next != null && p.next.val == p.val) p = p.next;
                p = p.next;// 往后移动一位，指向第一个不相同的节点
                q.next = p;// 删除重复节点
            } else {
                q.next = p;
                q = p;
                p = p.next; // 不重复，需要保留
            }
        }
        return root.next;// 最后去掉头结点
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}