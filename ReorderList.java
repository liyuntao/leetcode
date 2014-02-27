package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-2-27.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode[] arr = splitList(head); //将链表从中间一分为二
        mergeList(arr[0], reverseList(arr[1])); //反转后半段链表; 1-2-1-2的顺序合并链表
    }

    ListNode[] splitList(ListNode head) {
        int len = 0;
        ListNode pointer = head;
        while(pointer!=null) {
            len++;
            pointer = pointer.next;
        }

        int count = len/2;
        ListNode l1_last = head;
        while(count > 0) {
            l1_last = l1_last.next;
            count--;
        }
        ListNode l2_head = l1_last.next;
        l1_last.next = null;
        return new ListNode[] {head, l2_head};
    }

    ListNode reverseList(ListNode cur) { //cur now is l2's head
        ListNode last = null;
        ListNode next = null; //will store temporarily
        while(true) {
            next = cur.next; //store nextNode temporarily
            cur.next = last; //connect curNode to lastNode
            if(next == null) {
                return cur;//now cur is l2's head
            }
            last = cur;
            cur = next;
        }
    }

    ListNode mergeList(ListNode p1, ListNode p2) {
        ListNode l1_next, l2_next;
        ListNode l1_cur = p1;
        ListNode l2_cur = p2;
        while(true) {
            l1_next = l1_cur.next; //store
            l2_next = l2_cur.next; //store
            l1_cur.next = l2_cur; //link
            if(l1_next == null && l2_next ==null) break;
            l2_cur.next = l1_next; //link
            if(l2_next ==null) break;
            l1_cur = l1_next; //redirect l1_cur
            l2_cur = l2_next; //redirect l2_cur
        }
        return p1;
    }

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        ListNode l = Generator.genList(new int[]{1,2,3,4,5,6,7,8,9,10});
        obj.reorderList(l);
        Printer.print(l);
        l = Generator.genList(new int[]{1,2,3,4,5,6,7,8,9});
        obj.reorderList(l);
        Printer.print(l);
    }
}
