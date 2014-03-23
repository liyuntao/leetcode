package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;

/**
 * Created by amour on 14-3-23.
 */
public class SumRootToLeafNumbers {
    int total;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        total = 0;
        dfs(root, 0);
        return total;
    }

    public void dfs(TreeNode t, int sum) {
        if(t == null) return;
        if(t.left == null && t.right == null) {
            total += sum*10 + t.val;
        }else {
            dfs(t.left, sum*10 + t.val);
            dfs(t.right, sum*10 + t.val);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = Generator.genTree(new Integer[]{1, 2, 2, 3, 3, 3, 4});
        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
        System.out.println(obj.sumNumbers(t1));
    }
}
