package leetcode;

/**
 * Created by amour on 14-2-25.
 */
public class Pow_X_N2 {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        switch (n) {
            case 0:
                return 1;
            case 1:
                return x;
            case -1:
                return 1 / x;
        }
        double temp = pow(x, n / 2);
        return temp * temp * ((n & 1) == 0 ? 1 : (n > 0 ? x : 1 / x));
    }


    public static void main(String[] args) {
        Pow_X_N2 obj = new Pow_X_N2();
        long t1 = System.currentTimeMillis();
        System.out.println(obj.pow(-1.000, 51223127));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
