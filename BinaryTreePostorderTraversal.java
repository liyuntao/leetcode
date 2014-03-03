package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

import java.util.ArrayList;

/**
 * Created by amour on 14-3-3.
 */
public class BinaryTreePostorderTraversal {
    //TODO 改写为非递归
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        System.out.println(obj.postorderTraversal(Generator.genTree(new Integer[]{1,null,2,null,null,3,null})));
    }
}
