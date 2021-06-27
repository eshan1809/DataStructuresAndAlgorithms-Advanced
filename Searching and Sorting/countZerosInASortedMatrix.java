/*
Given a Binary Square Matrix where each row and column of the matrix is sorted in ascending order. Find the total number of Zeros present in the matrix.
*/

import java.util.*;
import java.io.*;

public class countZerosInASortedMatrix {

    public static int countZeros(int[][] mat) {
        // write your code here
        int count = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 0)
                    count++;
                else
                    break;
        return count;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println(countZeros(mat));
    }
}