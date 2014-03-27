package leetcode;

/**
 * Created by amour on 14-3-27.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int red = 0; // 0's
        int white = 0; // 1's
        int blue = 0; // 2's
        for(int i=0;i<A.length;i++) {
            if(A[i] == 0) {
                red++;
            }else if(A[i]==1) {
                white++;
            }else {
                blue++;
            }
        }
        for(int i=0;i<A.length;i++) {
            if(red>0) {
                A[i] = 0;
                red--;
            }else if(white >0) {
                A[i] = 1;
                white--;
            }else {
                A[i]=2;
                blue--;
            }
        }
    }
}
