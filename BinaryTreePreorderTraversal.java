package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

import java.util.ArrayList;

/**
 * Created by amour on 14-3-3.
 */
public class BinaryTreePreorderTraversal {
    //TODO 尝试非递归写法
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
        System.out.println(obj.preorderTraversal(Generator.genTree(new Integer[]{1, null, 2, null,null,3,4})));

        obj = new BinaryTreePreorderTraversal();
        System.out.println(obj.preorderTraversal(Generator.genTree(new Integer[]{})));
    }
}
