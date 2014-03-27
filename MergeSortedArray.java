package leetcode;

/**
 * Created by amour on 14-3-26.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0) return;
        int pa = m-1;
        int pb = n-1;
        for(int i=0;i<m+n;i++) {
            if(pa < 0) {
                for(int j=0;j<=pb;j++) {
                    A[j] = B[j];
                }
                break;
            }

            if(pb < 0) {
               break;
            }

            if(A[pa] > B[pb]) {
                A[m+n-1-i] = A[pa];
                pa--;
            }else {
                A[m+n-1-i] = B[pb];
                pb--;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
//        int A[] = {4,0,0,0,0,0};
//        int B[] = {1,2,3,5,6};
        int A[] = {1,0};
        int B[] = {2};
        obj.merge(A,1,B,B.length);
        for(int i:A) {
            System.out.print(i+" ");
        }
    }
}
