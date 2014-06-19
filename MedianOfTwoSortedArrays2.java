package leetcode;

/**
 * Created by liyuntao on 2014/6/18.
 */
public class MedianOfTwoSortedArrays2 {
    public double findMedianSortedArrays(int A[], int B[]) {
        int sum = A.length + B.length;
        if(sum % 2 != 0) {
            return findKth(A, 0, A.length - 1, B, 0, B.length - 1, sum / 2 + 1);
        } else {
            return (findKth(A, 0, A.length - 1, B, 0, B.length - 1, sum / 2 )
                  + findKth(A, 0, A.length - 1, B, 0, B.length - 1, sum / 2 + 1)
                ) / 2.0;
        }
    }

    private int findKth(int A[], int startA, int endA,
                        int B[], int startB, int endB,
                        int k) {
        int m = endA - startA + 1;
        int n = endB - startB + 1;
        if(m > n) return findKth(B, startB, endB, A, startA, endA, k); //只考虑a <= b的情况
        if(m < 1) return B[startB + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);

        int midA = Math.min(k/2, m), midB = k - midA;
        //如果a的第midA大的元素比b的第midB大的元素小，
        //那么删掉a的前midA个元素，在剩余的数中找第k-midA大的。
        if (A[startA + midA - 1] < B[startB + midB - 1])
            return findKth(A, startA + midA, endA, B, startB, endB, k - midA);
        else if (A[startA + midA - 1] > B[startB + midB - 1])
            return findKth(A, startA, endA, B, startB + midB, endB, k - midB);
        else
            return A[startA + midA - 1];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays2 obj = new MedianOfTwoSortedArrays2();
        int A[] = {11000};
        int B[] = {11001};
        System.out.println(obj.findMedianSortedArrays(A, B));

        int C[] = {1,2};
        int D[] = {1,2};
        System.out.println(obj.findMedianSortedArrays(C, D));

        int E[] = {1};
        int F[] = {2,3,4,5,6,7,8};
        System.out.println(obj.findMedianSortedArrays(E, F));

        int G[] = {};
        int H[] = {2,3,4};
        System.out.println(obj.findMedianSortedArrays(G, H));
    }
}
