package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-2-27.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthofBinaryTree obj = new MaximumDepthofBinaryTree();
        TreeNode t = Generator.genTree(new Integer[]{1, 3, 4, 5, 2, 3, 4, 5, 6, 3, -1, 4, 5, 6, 7, 7, 8, -1, -1, 3, 4});
        System.out.println(obj.maxDepth(t));
    }
}
