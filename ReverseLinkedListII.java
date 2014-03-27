package leetcode;

import leetcode.common.ListNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

/**
 * Created by amour on 14-3-27.
 * 使用插入法，将被选中片段的头节点一一插入到尾节点之后，耗时O(n)
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        ListNode p_first = next(head, m-1); // pointer to head of target Linked-part;updated every time
        ListNode p_last = next(head, n-1); // pointer to tail of target Linked-part;fixed

        ListNode tmp3 = null;
        if(m == 1) {
            head = p_last;// the real head
        }else {
            tmp3 = next(head, m-2);
        }

        while(p_first != p_last) {
            ListNode tmp = p_first.next; // store p_f's next temporary
            ListNode tmp2 = p_last.next; // store p_last's next temporary
            p_last.next = p_first;
            p_first.next = tmp2;
            p_first = tmp;
        }
        if(tmp3 != null) tmp3.next = p_last;
        return head;
    }

    private ListNode next(ListNode node, int times) {
        while(node != null && times > 0) {
            node = node.next;
            times--;
        }
        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedListII obj = new ReverseLinkedListII();
        ListNode head = obj.reverseBetween(Generator.genList(new int[]{1,2,3,4,5,6,7}), 2,4);
        Printer.print(head);
    }
}
