package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-3-28.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        int len = getLength(head);
        n = len==0? 0 : n % len;
        if(head == null || n==0) {
            return head;
        }else { //divide+re_link
            ListNode ori_head = head;
            ListNode p = next(head, len-n-1);
            head = p.next;// new head;
            p.next = null;
            p = head;
            while(p.next!=null) {
                p = p.next;
            }
            p.next = ori_head;
            return head;
        }
    }

    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private ListNode next(ListNode node, int times) {
        while(node != null && times > 0) {
            node = node.next;
            times--;
        }
        return node;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode l = Generator.genList(new int[]{1,2,3,4,5,6,7,8,9});
        Printer.print(obj.rotateRight(l, 0));
    }
}
