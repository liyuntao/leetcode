package leetcode;

/**
 * Created by amour on 14-3-23.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int num = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] != elem) A[num++] = A[i];
        }
        return num;
    }
}
