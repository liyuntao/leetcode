package leetcode;

/**
 * Created by amour on 14-3-24.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int num = 1;
        for(int i=1; i< A.length; i++) {
            if(A[i] != A[i-1]) A[num++] = A[i];
        }
        return num;
    }
}
