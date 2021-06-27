/*
1. Write an efficient algorithm that searches for a value in a m x n matrix. This matrix has the following properties:
a). Integers in each row are sorted from left to right.
b). The first integer of each row is greater than the last integer of the previous row.
*/

import java.util.*;
import java.io.*;

public class searchA2DMatrix {

    /*
     * your task is to complete this function which returns true if target exists in
     * the matrix else return false
     */
    public static boolean search(int[][] matrix, int target) {
        // write your code here
        int tr = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[0].length - 1]) {
                tr = i;
                break;
            }
        }
        if (tr == -1)
            return false;
        return Arrays.binarySearch(matrix[tr], target) >= 0;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();
        scn.close();
        boolean isFound = search(matrix, target);
        System.out.println(isFound);

    }
}