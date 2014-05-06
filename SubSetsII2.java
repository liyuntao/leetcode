package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liyuntao on 2014/5/6.
 */
public class SubSetsII2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(num);
        result.add(tmp);
        recur_branch(num, 0,true, tmp, result);
        recur_branch(num, 0,false, tmp, result);
        return result;
    }

    private void recur_branch(int[] num, int i, boolean isChoose, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if(i == num.length) return;
        ArrayList<Integer> tmp = new ArrayList<Integer>(list);
        if(isChoose) {
            if(i > 0 && num[i] == num[i-1] ) {
                if(tmp.size() ==0 || num[i] != tmp.get(tmp.size() - 1)) {
                    return;
                }
            }
            tmp.add(num[i]);
            result.add(tmp);
        }
        recur_branch(num, i+1,true, tmp, result);
        recur_branch(num, i+1,false, tmp, result);
    }

    public static void main(String[] args) {
        SubSetsII2 obj = new SubSetsII2();
        int[] num = {1,2,2};
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
