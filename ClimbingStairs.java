package leetcode;

/**
 * Created by amour on 14-3-24.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 4) return n; // 1, 2, 3
        int a = 2;
        int b = 3;
        int c = 5;
        while(n > 4) {
            c = c + b;
            a = b;
            b = c - a;
            n--;
        }
        return c;
    }

    public int climbStairs1(int n) { //递归
        if(0 < n && n < 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs2(int n) { //简单的dp实现
        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        if(0 < n && n < 2) return n;
        for(int i=2; i<n; i++) {
            s[i] = s[i-1] + s[i-2];
        }
        return s[n-1];
    }

    public int climbStairs3(int n) { //循环数组 省空间
        int[] s = new int[] {1, 1, 2};
        for (int i = 2; i <= n; i++) {
            s[i%3] = s[(i-1)%3] + s[(i-2)%3];
        }
        return s[n%3];
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs2(41));
        System.out.println(obj.climbStairs3(41));
        System.out.println(obj.climbStairs(41));
    }
}
