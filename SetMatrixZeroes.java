package leetcode;

/**
 * Created by amour on 14-3-29.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean first_row_hasZero = false;
        boolean first_column_hasZero = false;

        for(int i = 0; i<n; i++) {
            if(matrix[0][i] == 0) {
                first_row_hasZero = true;
                break;
            }
        }


        for(int i = 0; i<m; i++) {
            if(matrix[i][0] == 0) {
                first_column_hasZero = true;
                break;
            }
        }

        for(int i = 1; i<m; i++) {
            for(int j=1; j<n;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i<m; i++) {
            if(matrix[i][0] == 0) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<n; i++) {
            if(matrix[0][i] == 0) {
                for(int j=0;j<m;j++) {
                    matrix[j][i] = 0;
                }
            }
        }


        if(first_row_hasZero) {
            for(int i=0;i<n;i++) {
                matrix[0][i] = 0;
            }
        }

        if(first_column_hasZero) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

//        int[][] A = new int[5][3];
        int[][] B = {{1,1,3,4,7},{3,4,5,9,1},{5,6,1,5,3},{5,6,7,5,3},{8,6,7,5,7}};

        SetMatrixZeroes obj = new SetMatrixZeroes();
        obj.setZeroes(B);
//
        for(int i = 0; i<5; i++) {
            for(int j=0; j<5;j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }
}
