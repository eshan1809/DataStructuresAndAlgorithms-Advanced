/*
1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.
*/

import java.util.*;

public class longestPalindromicSubsequences {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        int[][] dp = new int[str.length()][str.length()];
        for (int k = 0; k < dp.length; k++) {
            for (int i = 0, j = k; i < dp.length && j < dp.length; i++, j++) {
                if (k == 0)
                    dp[i][j] = 1;
                else if (k == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                else
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? dp[i + 1][j - 1] + 2
                            : Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        System.out.println(dp[0][dp.length - 1]);
    }
}
