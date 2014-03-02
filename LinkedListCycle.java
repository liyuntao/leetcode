package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-2-28.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode point1 = head;
        ListNode point2 = head;
        if(head != null && head.next == head) {
            return true; //only one node tails itself
        }

        while(point2 != null) {
            point1 = point1.next;
            point2 = point2.next;
            if(point2 != null) {
                point2 = point2.next;
            }

            if(point1 == point2 && point1 != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle obj = new LinkedListCycle();
        ListNode l = Generator.genList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(obj.hasCycle(l));

        l = null;
        System.out.println(obj.hasCycle(l));

        l = new ListNode(1);
        System.out.println(obj.hasCycle(l));

        l = new ListNode(1);
        l.next = l;
        System.out.println(obj.hasCycle(l));

        l =  Generator.genList(new int[]{1, 2});
        l.next.next = l;
        System.out.println(obj.hasCycle(l));
    }

}
