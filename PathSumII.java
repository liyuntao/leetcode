package leetcode;

import leetcode.common.TreeNode;
import leetcode.util.Generator;
import leetcode.util.Printer;

import java.util.*;

/**
 * Created by amour on 14-2-28.
 */
public class PathSumII {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
            check(root, sum, 0);
        }
        return result;
    }

    void check(TreeNode t, int sum, int cur) {
        stack.push(t.val);
        if(t.left == null && t.right == null) { //某条路径走到尽头 判断总和
            if(cur + t.val == sum) { //存在结果
                //处理结果集合
                ArrayList<Integer> a_set_of_result = new ArrayList<Integer>();
                for(int i= stack.size()-1;i>=0;i--) {
                    a_set_of_result.add(stack.get(i));
                }
                result.add(a_set_of_result);
            }
        }else {//递归的向左右子节点继续判断下去
            if(t.left!=null) check(t.left, sum, cur + t.val);
            if(t.right!=null) check(t.right, sum, cur + t.val);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
        TreeNode tree = Generator.genTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        ArrayList<ArrayList<Integer>> res = obj.pathSum(tree, 22);
        for(ArrayList<Integer> arr:res) {
            System.out.print("[");
            for(Integer i:arr) {
                System.out.print(i+" ");
            }
            System.out.println("]");
        }

//        LinkedList<Integer> l = new LinkedList<Integer>();
//        l.offer(5);
//        l.offer(7);
//        l.offer(9);
//        l.offer(12);
//        System.out.println(l.poll());
//        System.out.println(l.poll());
//        System.out.println(l.poll());
//        System.out.println(l.poll());
    }
}
