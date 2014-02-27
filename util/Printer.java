package leetcode.util;

import leetcode.common.ListNode;

import java.util.LinkedList;

/**
 * Created by amour on 14-2-27.
 */
public class Printer {
    public static void print(int[] t) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<t.length;i++) {
            result.append(t[i]).append(" ");
        }
        System.out.println(result);
    }

    public static void print(ListNode node) {
        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val).append(" ");
            node = node.next;
        }
        System.out.println(result);
    }

//    public static void print(LinkedList list) {
//        StringBuilder result = new StringBuilder();
//        for(Object o:list) {
//            result.append(o.toString()).append(" ");
//        }
//        System.out.println(result);
//    }
}
