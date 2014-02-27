package leetcode;

/**
 * Created by amour on 14-2-26.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = A[0];
        for(int i=1 ;i<A.length;i++) {
            result^=A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(new int[]{1,2,4,5,6,5,4,1,6}));

    }
}
