/*
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.
*/

import java.io.*;
import java.util.*;

public class maximumSumOfMNonoverlappingSubarrays {

    public static int solution(int[] arr, int m, int k) {
        // write your code here
        int n = arr.length;
        int[] pSum = new int[n];
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];
        pSum[0] = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            pSum[i - k + 1] = sum;
        }

        int[][] dp = new int[n][m + 1];

        for (int j = 1; j <= m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (j * k > n - i)
                    continue;
                int exc = i + 1 < n ? dp[i + 1][j] : 0;
                int inc = pSum[i] + (i + k < n ? dp[i + k][j - 1] : 0);
                dp[i][j] = Math.max(inc, exc);
            }
        }
        return dp[0][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, m, k));
    }
}
