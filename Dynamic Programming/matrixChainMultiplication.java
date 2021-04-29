/*
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
*/

import java.util.*;

public class matrixChainMultiplication {
    public static int mcm(int[] arr) {
        // write your code here
        int n = arr.length - 1;
        int[][] dp = new int[n][n];
        for (int k = 1; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                int min = Integer.MAX_VALUE;
                for (int x = i; x < j; x++)
                    min = Math.min(min, dp[i][x] + dp[x + 1][j] + arr[i] * arr[x + 1] * arr[j + 1]);
                dp[i][j] = min;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(mcm(arr));
    }
}
