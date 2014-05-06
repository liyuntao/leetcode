package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liyuntao on 2014/5/6.
 */
public class SubSetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        recur_branch(num, 0, list, result);
        return result;
    }

    private void recur_branch(int[] num, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> tmp = new ArrayList<Integer>(list);
        result.add(tmp);

        for(int i = k; i<num.length; i++) {
            //each step of loop, there's two branch whether fetch or not to fetch this number
            if( i > k && num[i] == num[i-1]) continue;
            tmp.add(num[i]);
            recur_branch(num, i+1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSetsII obj = new SubSetsII();
        int[] num = {1,3,4,2,2,3};
        ArrayList<ArrayList<Integer>> result = obj.subsetsWithDup(num);
        for (ArrayList<Integer> s : result) {
            System.out.print("[");
            for(Integer i : s) {
                System.out.print(" " + i);
            }
            System.out.println(" ]");
        }
    }
}
