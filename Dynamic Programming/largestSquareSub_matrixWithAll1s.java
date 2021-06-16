/*
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
*/

import java.io.*;
import java.util.*;

public class largestSquareSub_matrixWithAll1s {
    public static int solution(int[][] arr) {
        // write your code here
        int n = arr.length, m = arr[0].length, max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = arr[i][m - 1];
            if (dp[i][m - 1] == 1)
                max = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = arr[n - 1][i];
            if (dp[n - 1][i] == 1)
                max = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (arr[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
