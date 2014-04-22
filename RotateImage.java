package leetcode;

/**
 * Created by amour on 14-3-29.
 * 为了简化代码书写与可读性，采用矩阵转至＋每行reverse的思路
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n < 2) return;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n/2;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage obj = new RotateImage();
        int[][] B = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int i = 0; i<4; i++) {
            for(int j=0; j<4;j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        obj.rotate(B);
        System.out.println();
        for(int i = 0; i<4; i++) {
            for(int j=0; j<4;j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }

}
