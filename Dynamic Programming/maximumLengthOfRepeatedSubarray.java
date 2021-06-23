/*
1. You are given two arrays of integers arr1 and arr2.
2. You have to find the maximum length of subarray that appears in both the given arrays.
*/

import java.io.*;
import java.util.*;

public class maximumLengthOfRepeatedSubarray {
    public static int solution(int[] arr1, int[] arr2) {
        // write your code here
        int n = arr1.length, m = arr2.length, max = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr1, arr2));
    }
}
