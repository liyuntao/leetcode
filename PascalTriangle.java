package leetcode;

import java.util.ArrayList;

/**
 * Created by amour on 14-3-4.
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<numRows; i++) {
            ArrayList<Integer> one_line = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                one_line.add(c(i, j));
            }
            result.add(one_line);
        }
        return result;
    }

    public static int c(int n, int m) {
        if(m == 0 || n == m) return 1;
        if(n - m < m) return c(n, n-m);
        long up = 1;
        long down = 1;
        for(int i = 0; i < m; i++) {
            up *= n-i;
            down *= m-i;
        }
        return ((int)(up/down));
    }

    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
        ArrayList<ArrayList<Integer>> result = obj.generate(3);
        for(ArrayList<Integer> one_line: result) {
            System.out.print("[");
            for(int i : one_line) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
