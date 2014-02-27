package leetcode;

import leetcode.common.TreeNode;

/**
 * Created by amour on 14-2-27.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root.left) && checkBalanced(root.right);
    }
    //TODO
    boolean checkBalanced(TreeNode t) {

        return false;
    }

    public static void main(String[] args) {

    }

}
