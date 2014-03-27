package leetcode;

/**
 * Created by amour on 14-3-27.
 */
public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        int[] result = {-1,-1};
        if(A.length < 1 ) return result;

        int low = 0;
        int high = A.length-1;
        int middle;

        while(low <= high) {
            middle = (low+high)/2;
            if(A[middle] == target) {
                result[0] = findLeftBorder(A,0, middle-1,target);
                result[1] = findRightBorder(A,middle+1, A.length-1,target);
                return result;
            }else if(A[middle] > target) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return result;
    }

    private int findLeftBorder(int A[], int start, int end, int target) {
        if(start > end) return end+1;
        int low = start;
        int high = end;
        int middle;
        while(low <= high) {
            middle = (low+high)/2;
            if(A[middle] == target) {
                return findLeftBorder(A,start,middle-1,target);
            }else if(A[middle] < target) {
                low = middle+1;
            }
        }
        return end+1;
    }

    private int findRightBorder(int A[], int start, int end, int target) { //return end+1
        if(start > end) return start-1;
        int low = start;
        int high = end;
        int middle;
        while(low <= high) {
            middle = (low+high)/2;
            if(A[middle] == target) {
                return findRightBorder(A, middle + 1, end, target);
            }else if(A[middle] > target) {
                high = middle-1;
            }
        }
        return start-1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 7, 7, 8, 8, 10};
        SearchForARange obj = new SearchForARange();
//        System.out.println(obj.findLeftBorder(A,0,2,8));
//        System.out.println(obj.findRightBorder(A,3,5,7));
        int[] B = obj.searchRange(A, 30);
        System.out.println(B[0] + " "+ B[1]);
    }
}
