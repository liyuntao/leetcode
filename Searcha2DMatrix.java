package leetcode;

/**
 * Created by amour on 14-3-3.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int col = matrix[0].length;
        int row = matrix.length;
        int low = 0;
        int high = col * row -1;

        int middle = 0;
        while(low <= high){
            middle = (low + high)/2;
            if(matrix[middle/col][middle%col] == target) {
                return true;
            }else if(matrix[middle/col][middle%col] > target) {
                high = middle -1 ;
            }else {
                low = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Searcha2DMatrix obj = new Searcha2DMatrix();
        System.out.println(obj.searchMatrix(new int[][]{{1,2,3,4,5},{9,11,12,24,35},{44,57,69,79,99}} , 57));
        System.out.println(obj.searchMatrix(new int[][]{{1}} , 2));
    }
}
