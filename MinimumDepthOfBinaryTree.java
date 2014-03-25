package leetcode;

import leetcode.common.TreeNode;

/**
 * Created by amour on 14-3-26.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return min(root.left, root.right)+1;
    }

    private int min(TreeNode a, TreeNode b) { // make sure the Node is leaf
        if(a == null) return minDepth(b);
        if(b == null) return minDepth(a);
        return Math.min(minDepth(a), minDepth(b));
    }
}
