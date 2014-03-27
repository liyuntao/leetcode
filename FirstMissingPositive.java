package leetcode;

/**
 * Created by amour on 14-3-27.
 * 从前到后遍历一遍, 遇到元素i就将它交换到数组索引为i－1的位置上。
 * 第二次遍历找the first positive element which not on its index;
 * 这个题很容易出错
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A.length == 0) return 1;
        for(int i=0;i<A.length;i++) {
            if(0 < A[i] && A[i] < A.length
                        && A[i]!=i+1 // do not swap with itself
                        && A[i]!=A[A[i]-1]
                                            ) {
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
                i--;
            }
        }

        for(int i=0;i<A.length;i++) {
            if(A[i] != i+1) {
                return i+1;
            }
        }
        return A.length+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] A = new int[] {-1,4,2,1,9,10};
        int result = obj.firstMissingPositive(A);
        for(int i=0;i<A.length;i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        System.out.println(result);
        System.out.println(obj.firstMissingPositive(new int[]{}));
        System.out.println(obj.firstMissingPositive(new int[]{2}));
        System.out.println(obj.firstMissingPositive(new int[]{1}));
        System.out.println(obj.firstMissingPositive(new int[]{3,1,-2,-3,9,7,-4,6,8}));
    }
}
