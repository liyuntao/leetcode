package leetcode;

import leetcode.common.ListNode;

/**
 * Created by amour on 14-3-24.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        ListNode real_head = head.next;
        ListNode pre_tmp = null;
        while(p != null && p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = p;
            if(pre_tmp != null) pre_tmp.next = tmp;
            pre_tmp = p;
            p = p.next;
        }
        return real_head;
    }
}
