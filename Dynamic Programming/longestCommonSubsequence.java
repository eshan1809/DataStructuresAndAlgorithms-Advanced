/*
1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.
*/

import java.util.*;

public class longestCommonSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next(), str2 = scn.next();
        scn.close();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}