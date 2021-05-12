/*
1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
*/

import java.io.*;
import java.util.*;

public class burstBalloons {
    public static int solution(int[] arr) {
        // write your code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                int x1 = (i == 0 ? 1 : arr[i - 1]), x2 = (j == n - 1 ? 1 : arr[j + 1]), pro = x1 * x2;
                if (k == 0)
                    dp[i][j] = pro * arr[i];
                else {
                    int max = 0;
                    for (int x = i; x <= j; x++) {
                        int left = (i == x ? 0 : dp[i][x - 1]), right = (j == x ? 0 : dp[x + 1][j]);
                        max = Math.max(max, pro * arr[x] + left + right);
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
