package leetcode;

/**
 * Created by amour on 14-3-27.
 */
public class SortColors2 {
    public void sortColors(int[] A) {
        int pre = 0;
        int i = 0;
        int last = A.length-1;
        while(i<=last) {
            if(A[i] == 2) {
                swap(A, i, last);
                last--;
                i--;
            }else if(A[i] == 0) {
                swap(A, i, pre);
                pre++;
            }
            i++;
        }
    }

    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void main(String[] args) {
        SortColors2 obj = new SortColors2();
//        int[] result = new int[]{1,0,1,2,2,1,0,2,1,1,1,0};
//        int[] result = new int[]{};
//        int[] result = new int[]{2,2,2,0,0,0};
        int[] result = new int[]{1,0};
        obj.sortColors(result);
        for(int i:result) {
            System.out.print(i+" ");
        }
    }
}
