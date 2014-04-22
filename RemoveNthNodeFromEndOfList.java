package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-3-28.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        if(n == 0) return head;
        int len = getLength(head);

        if(len == n) {
            ListNode p = head;
            head = p.next;
            p.next = null;
        }else {
            ListNode p = next(head, len-n-1);
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = null;
        }
        return head;
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
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        ListNode head = obj.removeNthFromEnd(Generator.genList(new int[]{1,2,3,4,5,6,7}), 7);
        Printer.print(head);
    }
}
