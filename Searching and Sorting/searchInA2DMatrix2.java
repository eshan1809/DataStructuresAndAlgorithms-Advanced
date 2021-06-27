/*
1. Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
a). Integers in each row are sorted in ascending from left to right.
b). Integers in each column are sorted in ascending from top to bottom.
*/

import java.util.*;
import java.io.*;

public class searchInA2DMatrix2 {

    /*
     * your task is to complete this function which returns true if target exists in
     * the matrix else return false
     */
    public static boolean search(int[][] matrix, int target) {
        // write your code here
        return false;
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