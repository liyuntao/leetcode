package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-3-29.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        int tmp = head.val;
        ListNode pre = head;
        ListNode p = head.next;
        while(p != null) {
            if(p.val == tmp) {
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            }else {
                tmp = p.val;
                p = p.next;
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode head = obj.deleteDuplicates(Generator.genList(new int[]{1,1,2,2,3,3,3,4,5,6}));
        Printer.print(head);
    }
}
