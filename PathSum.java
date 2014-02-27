package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-2-27.
 */
public class PathSum {
    boolean isExists;
    public boolean hasPathSum(TreeNode root, int sum) {
        isExists = false;
        if(root != null) {
            check(root, sum, 0);
        }
        return isExists;
    }

    void check(TreeNode t, int sum, int cur) {
        if(t.left == null && t.right == null) {
            if(cur + t.val == sum) isExists = true; //某条路径走到尽头 判断总和
        }else {//递归的向左右子节点继续判断下去
            if(!isExists && t.left!=null) check(t.left, sum, cur + t.val);
            if(!isExists && t.right!=null) check(t.right, sum, cur + t.val);
        }
    }

    public static void main(String[] args) {
        PathSum obj = new PathSum();
        TreeNode tree = Generator.genTree(new Integer[]{6, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});

        System.out.println(obj.hasPathSum(tree, 22));
    }
}
