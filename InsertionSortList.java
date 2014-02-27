package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-2-27.
 */
public class InsertionSortList {
    public ListNode head;
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        this.head = head;
        ListNode main_pre= head;
        ListNode main_now = head.next;

        while(main_now!=null) {
            int cur = main_now.val;
            ListNode lastPoint = null;
            ListNode point = this.head;
            boolean isMoved = false;
            while(point != main_now) {
                if(point.val > cur) {
                    swap(head, lastPoint, main_now, main_pre);
                    isMoved = true;
                    break;
                }
                lastPoint = point;
                point = point.next;
            }
            if(isMoved) {
                main_now = main_pre.next;
            }else {
                main_now = main_now.next;
                main_pre = main_pre.next;
            }
        }
        return this.head;
    }

    void swap(ListNode head, ListNode afterThis, ListNode beSwap, ListNode pre_beSwap) {
        pre_beSwap.next = beSwap.next;
        if(afterThis == null) {
            beSwap.next = this.head;
            this.head = beSwap;
        }else {
            beSwap.next = afterThis.next;
            afterThis.next = beSwap;
        }
    }


    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        Printer.print(obj.insertionSortList(Generator.genList(new int[]{123,33,55,67,64,9,78,86,34,32,57,345})));
        //Printer.print(Generator.genList(new int[]{123,33,55,67,64,9,78,86,34,32,57,345}));
    }
}
