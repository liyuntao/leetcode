package leetcode;

import java.util.ArrayList;

/**
 * Created by amour on 14-2-24.
 */
public class Combinations {

    ArrayList<ArrayList> ret = null;

    public void dfs(int n, int k, int pos, ArrayList tmp){

        if(tmp.size() == k){
            ret.add(new ArrayList(tmp));
            return;
        }

        for(int i=pos; i<=n; i++){
            tmp.add(i);
            dfs(n, k, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    // 从n中选k个
    public ArrayList<ArrayList> combine(int n, int k) {
// Start typing your Java solution below
// DO NOT write main() function
        ret = new ArrayList<ArrayList>();
        ArrayList tmp = new ArrayList();
        dfs(n, k, 1, tmp);
        return ret;
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
    }
}
