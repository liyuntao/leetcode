package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-3-26.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        pre_order(root);
        while(root != null) {
            if(root.left != null) {
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private void pre_order(TreeNode t) {
        if(t == null) return;
        if(t.left != null) pre_order(t.left);
        if(t.right != null) { //右树嫁接在左树上
            if(t.left == null) {
                t.left = t.right;
                t.right = null;
            }else {
                TreeNode tmp = t;
                while(tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.left = t.right;
                t.right = null;
            }
            pre_order(t.left);
        }
    }

    public static void main(String[] args) {
        //TreeNode t = Generator.genTree(new Integer[]{1,null,2,null,null,4,3});
        TreeNode t = Generator.genTree(new Integer[]{1,2,3,4,5,null,6});
        TreeNode t2 = t;
        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        obj.flatten(t2);
        while(t != null) {
            System.out.println(t.val);
            t = t.right;
        }
    }
}
