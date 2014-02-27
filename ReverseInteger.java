package leetcode;

/**
 * Created by amour on 14-2-25.
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean neg = x < 0;
        if(neg) x = -x;
        int result = 0;
        while(x!=0) {
            result = result*10 + x%10;
            x/=10;
        }
        return (neg?-1:1 )* result;

    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        System.out.println(obj.reverse(133400));
    }
}
