/*
1. You have a matrix of N*N Dimension.
2. You have to convert matrix into transpose.
3. Transpose matrix is defined as, matrix flipped over its main diagonal.
*/

import java.util.*;

public class transposeOfMatrixWithDimensionN_X_N {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
    public static void transpose(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        scn.close();
        transpose(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}