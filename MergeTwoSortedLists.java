package leetcode;

import leetcode.common.ListNode;

/**
 * Created by amour on 14-3-27.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head;
        if(p1.val <= p2.val) {
            head = p1;
            p1 = p1.next;
        }else{
            head = p2;
            p2 = p2.next;
        }
        ListNode p = head;

        while(true) {
            if(p1 == null) {
                p.next = p2;
                break;
            }
            if(p2 == null) {
                p.next = p1;
                break;
            }
            if(p1.val<=p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
