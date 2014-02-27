package leetcode;

/**
 * Created by amour on 14-2-25.
 */
public class Pow_X_N {
    public double pow(double x, int n) {
        if(x == 1) return 1;
        if(x == -1) return n%2==0? 1:-1 ;

        if(n==0){
            return 1;
        }else if(n < 0) {
            return 1.0/pow(x, -n);
        }else { // n > 0
            return innerPow(x, n);
        }
    }

    double innerPow(double x, int n){ //n >= 0
        if(n==0) {
            return 1;
        }else if(n == 1) {
            return x;
        }else {
            double tmp;
            if(n % 2 ==0) {
               tmp = innerPow(x, n/2);
               return tmp * tmp;
            }else{
                tmp = innerPow(x, (n-1)/2);
               return tmp*tmp * x;
            }
        }
    }


    public static void main(String[] args) {
        Pow_X_N obj = new Pow_X_N();
        long t1 = System.currentTimeMillis();
        System.out.println(obj.pow(-1, 5123127));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
