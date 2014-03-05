package leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by amour on 14-3-4.
 */
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int j=0; j<=rowIndex; j++) {
            result.add(c(rowIndex, j));
        }
        return result;
    }

    public static int c(int n, int m) {
        if(m == 0 || n == m) return 1;
        if(n - m < m) return c(n, n-m);
        long up = 1;
        long down = 1;
        for(int i = 0; i < m; i++) {
            //if(up * (n-i) < 0) { //发生溢出
                //接近30时候，up会超过long的最大值，丑陋的化简一下
                while(up % 5 == 0 && down%5 ==0) {
                    up/=5;
                    down/=5;
                }
                while(up % 2 == 0 && down%2 ==0) {
                    up/=2;
                    down/=2;
                }
                while(up % 3 == 0 && down%3 ==0) {
                    up/=3;
                    down/=3;
                }
            //}

            up *= n-i;
            down *= m-i;

        }
        //System.out.println(up+" "+down+" "+up/down);
        return ((int)(up/down));
    }

    public static void main(String[] args) {
        PascalTriangleII obj = new PascalTriangleII();
        ArrayList<Integer> result = obj.getRow(31);
        System.out.print("[");
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
