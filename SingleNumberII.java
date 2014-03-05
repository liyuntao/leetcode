package leetcode;

/**
 * Created by amour on 14-2-26.
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for(int i=0; i<32; i++) {
            for (int j = 0; j < A.length; j++) {
                if ((A[j] >> i & 1) == 1) {
                    count[i]++;
                }
            }
            result = result | ((count[i] % 3) <<i );
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberII obj = new SingleNumberII();
        System.out.println(obj.singleNumber(new int[]{1,2,4,5,6,5,4,1,6,1,5,6,4}));
    }
}
