package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-3-3.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }else if (p != null && q != null){
            if(p.val != q.val) {
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();
        TreeNode p = Generator.genTree(new Integer[]{1,2});
        TreeNode q = Generator.genTree(new Integer[]{1,2});
        System.out.println(obj.isSameTree(p, q));

        p = Generator.genTree(new Integer[]{1,2,null,4});
        q = Generator.genTree(new Integer[]{1,2,null,4});
        System.out.println(obj.isSameTree(p, q));
    }
}
