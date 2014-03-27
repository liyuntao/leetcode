package leetcode;

/**
 * Created by amour on 14-3-26.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A.length == 0) return -1;
        return inner_search(A, 0, A.length-1, target);
    }

    private int inner_search(int[] A, int start, int end, int target) {
        if(start > end) return -1;
        int low = start;
        int high = end;
        int middle;
        while(low <= high) {
            middle = (low + high)/2;
            if(A[middle] == target) return middle;
            if(A[middle] < A[high]) { // right part is in order
                if(A[middle] < target && target <= A[high]) {
                    return binary_search(A, middle+1, high, target);
                }else {
                    return inner_search(A, low, middle - 1, target);
                }
            }else { // left part is in order
                if(A[middle] > target && A[low] <= target) {
                    return binary_search(A, low, middle-1, target);
                }else {
                    return inner_search(A,middle+1, high,target);
                }
            }
        }
        return -1;
    }

    private int binary_search(int B[], int start, int end, int target) {
        if(B.length ==0) return -1;
        int low=start;
        int high = end;
        int middle;
        while(low <= high) {
            middle = (low + high)/2;
            if(B[middle] == target) return middle;
            if(B[middle] > target) {
                high = middle-1;
            }else{
                low = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 4));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 5));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 6));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 7));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 1));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 2));
        System.out.println(obj.search(new int[]{4,5,6,7,8,1,2,3}, 3));
    }
}
