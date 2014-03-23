package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-3-23.
 * 思路：第一次迭代，将节点相加，不考虑进位问题
 * 第二次迭代专门处理进位，极端情况下会再增加一个值为1的尾节点
 *
 * 在两个链表长度相差很大的情况下，第二次迭代的效率可能低，但这样可读性较好
 * 时间复杂度O(n)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2:l1;
        }

        ListNode p = new ListNode(l1.val + l2.val);
        ListNode head = p;
        while(l1.next != null && l2.next != null) { //handle plus
            l1 = l1.next;
            l2 = l2.next;
            p.next = new ListNode(l1.val + l2.val);
            p = p.next;
        }
        l1 = l1.next;
        l2 = l2.next;
        p.next = l1 == null ? l2:l1;

        p = head;
        while(p != null) { // 进位
            if(p.val > 9) {
                if(p.next == null) {
                    p.next = new ListNode(p.val/10);
                }else{
                    p.next.val += p.val/10;
                }
                p.val%=10;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = Generator.genList(new int[]{2, 4, 3});
        ListNode l2 = Generator.genList(new int[]{5, 6, 6, 9});
        AddTwoNumbers obj = new AddTwoNumbers();
        Printer.print(obj.addTwoNumbers(l1, l2));
    }
}
