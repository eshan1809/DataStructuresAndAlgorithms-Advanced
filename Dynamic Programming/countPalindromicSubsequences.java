/*
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.
*/

import java.util.*;

public class countPalindromicSubsequences {
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
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j];
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] += 1;
                    else
                        dp[i][j] -= dp[i + 1][j - 1];
                }
            }
        }
        System.out.println(dp[0][dp.length - 1]);
    }
}
