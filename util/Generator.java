package leetcode.util;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

/**
 * Created by amour on 14-2-27.
 */
public class Generator {
    public static TreeNode genTree(Integer[] treeArray) {
        if(treeArray.length == 0) {
            return null;
        } else {
            TreeNode[] p_arr = new TreeNode[treeArray.length];
            for(int i=0; i<p_arr.length; i++) {
                p_arr[i] = treeArray[i] == null ? null: new TreeNode(treeArray[i]);
            }
            for(int i=0; i<p_arr.length; i++) {
                if(p_arr[i] == null) continue;
                if(2*i+1 < p_arr.length) p_arr[i].left = p_arr[2*i+1];//2i+1
                if(2*i+2 < p_arr.length) p_arr[i].right = p_arr[2*i+2];//2i+2
            }
            return p_arr[0];
        }

    }

    public static ListNode genList(int[] arr) {
        if(arr.length == 0) return null;
        ListNode result = new ListNode(arr[0]);
        ListNode cur = result;
        for(int i=1; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return result;
    }
}
