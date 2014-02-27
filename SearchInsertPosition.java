package leetcode;

/**
 * Created by amour on 14-2-23.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length-1;

        int middle = 0;
        while(low <= high){
            middle = (low + high)/2;
            if(A[middle] == target) {
                return middle;
            }else if(A[middle] > target) { //在左半
                high = middle -1 ;
            }else {
                low = middle + 1;
            }
        }
        return A[middle] > target ? middle: middle+1;
    }

    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();
        System.out.println(obj.searchInsert(new int[]{1,2,5,6}, 3));
    }
}
