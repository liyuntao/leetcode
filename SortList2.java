package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-2-23.
 * 递归实现
 */
public class SortList2 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //divide
        int length = getLength(head);
        ListNode h1 = head;
        ListNode tmp = next(h1, length/2-1);
        ListNode h2 = tmp.next;
        tmp.next = null;
        //concer
        h1 = sortList(h1);
        h2 = sortList(h2);
        return doMerge(h1, h2);
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

    public ListNode doMerge(ListNode h1, ListNode h2) { // return firstNode of the part
        if (h2 == null) return h1;

        ListNode start1 = h1;
        ListNode start2 = h2;

        ListNode part_head ;
        if(start1.val <= start2.val) {
            part_head = start1;
            start1 = start1.next;
        }else{
            part_head = start2;
            start2 = start2.next;
        }
        ListNode p = part_head;
        while(true) {
            if(start1 == null) {
                p.next = start2;
                break;
            }
            if(start2 == null) {
                p.next = start1;
                break;
            }
            if(start1.val <= start2.val) {
                p.next = start1;
                p = p.next;
                start1 = start1.next;
            }else{
                p.next = start2;
                p = p.next;
                start2 = start2.next;
            }
        }
        return part_head;
    }

    public static void main(String[] args) {
        SortList2 obj = new SortList2();
        ListNode l = Generator.genList(new int[]{4,19,14,5,-3,1,8,5,11,15});
        Printer.print(obj.sortList(l));
    }
}