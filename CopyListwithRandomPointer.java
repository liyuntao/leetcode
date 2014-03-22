package leetcode;

import leetcode.common.RandomListNode;


/**
 * Created by amour on 14-3-21.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode p1 = head;
        RandomListNode p2 = new RandomListNode(p1.label);
        RandomListNode p3 = new RandomListNode(p1.label);
        RandomListNode p2_head = p2;
        RandomListNode p3_head = p3;
        while(p1.next != null) {
            RandomListNode tmp = p1.next; //record the next
            p2.next = new RandomListNode(tmp.label);
            p3.next = new RandomListNode(1);
            p1.next = p2;
            p2.random = p1;
            p3.random = p1;
            p2 = p2.next;
            p3 = p3.next;
            p1 = tmp;
        }
        p1.next = p2;
        p2.random = p1;
        p3.random = p1;

        p1 = head;
        p2 = p2_head;

        while(true) {
            if(p1.random != null) {
                p2.random = p1.random.next; // made random->link
            }else {
                p2.random = null; //repair next->link
            }
            if(p2.next == null) {
                p1.next = null; // very important
                break;
            }
            p2 = p2.next;
            p1 = p2.random;
        }

        p1 = head;
        p3 = p3_head;
        while(p3.next!=null) {
            p1.next = p3.next.random;
            p1 = p1.next;
            p3 = p3.next;
        }
        return p2_head;
    }

    public static void main(String[] args) {
        CopyListwithRandomPointer obj = new CopyListwithRandomPointer();
        RandomListNode p1 = new RandomListNode(5);
        RandomListNode p2 = new RandomListNode(4);
        RandomListNode p3 = new RandomListNode(6);
        RandomListNode p4 = new RandomListNode(3);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p1.random = p2;
        p2.random = p1;
        p3.random = p1;
        p4.random = p2;

        RandomListNode result = obj.copyRandomList(p1);
        while(result != null) {
            System.out.print(result.label+"  ");
            System.out.println(result.random == null ? "null" : result.random.label);
            result = result.next;
        }
    }
}
