package leetcode;

/**
 * Created by amour on 14-2-27.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(checkAll9(digits)) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else {
            digits[digits.length-1]++;
            for(int i=digits.length-1; i>=0; i--) {
                if(digits[i]<= 9) {
                    //pass
                }else {
                    digits[i] %= 10;
                    digits[i-1]++;
                }
            }
            return digits;
        }
    }

    boolean checkAll9(int[] digits) {
        for(int i=0; i<digits.length;i++) {
            if(digits[i] != 9) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] result = obj.plusOne(new int[]{3, 9, 7, 9, 5, 9, 9, 9, 6});
        for(int i=0; i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }
}
