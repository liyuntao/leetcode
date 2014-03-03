package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-3-4.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.left, root.right);
    }

    boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSame(t1.left, t2.right) && isSame(t2.left, t1.right);
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode t1 = Generator.genTree(new Integer[]{1,2,2,3,3,3,4});
        System.out.println(obj.isSymmetric(t1));

        TreeNode t2 = Generator.genTree(new Integer[]{1,2,2,3,3,3,3});
        System.out.println(obj.isSymmetric(t2));
    }
}
