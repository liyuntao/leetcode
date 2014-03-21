package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-2-23.
 * 这个迭代的实现很不优雅，改进版在SortList2
 */
public class SortList {
    ListNode whole_head = null;
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int length = getLength(head);
        ListNode p;
        whole_head = head;
        int step = 1;
        while(step < length) {
            p = whole_head; // outer cycle start from whole_link's headNode
            ListNode part_outer_start = null;
            boolean isFirst = true;
            while(p!= null) {
                ListNode part_outer_tail = next(p, 2*step);

                ListNode part_head = doMerge(p, step); //merge the part

                if(isFirst) {
                    whole_head = part_head;
                    isFirst = false;
                }

                ListNode part_tail = safe_next(part_head, 2 * step - 1);

                //combine part back to the whole linkedlist
                if(part_outer_start!=null) {
                    part_outer_start.next = part_head;
                }
                part_tail.next = part_outer_tail;

                part_outer_start = part_tail;

                p = part_outer_tail;
            }
            part_outer_start = null;
            step*=2;
        }
        return whole_head;
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

    private ListNode safe_next(ListNode node, int times) {
        while(node.next != null && times > 0) {
            node = node.next;
            times--;
        }
        return node;
    }

    public ListNode doMerge(ListNode p1, int step) { // return firstNode of the part
        if (p1.next == null) return p1;
        //cut off from middle and the end
        ListNode start1 = p1;
        ListNode start2 = next(p1, step);
        if(start2 == null) return p1;
        safe_next(p1, 2 * step - 1).next = null;
        next(p1, step - 1).next = null;

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
        SortList obj = new SortList();
        ListNode l = Generator.genList(new int[]{4,19,14,5,-3,1,8,5,11,15});
        Printer.print(obj.sortList(l));

//        ListNode l1 = Generator.genList(new int[]{2, 9, 6});
//        Printer.print(obj.doMerge(l1, 2));
    }
}