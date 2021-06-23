/*
1. You are given three strings s1, s2 and s3.
2. You have to find the longest common sub-sequence in the given strings.
*/

import java.util.*;

public class LCSofThreeStrings {

    public static void solution(String str1, String str2, String str3) {
        // write your code here
        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                for (int k = str3.length() - 1; k >= 0; k--) {
                    if (str1.charAt(i) == str2.charAt(j) && str1.charAt(i) == str3.charAt(k))
                        dp[i][j][k] = dp[i + 1][j + 1][k + 1] + 1;
                    else
                        dp[i][j][k] = Math.max(Math.max(dp[i + 1][j][k], dp[i][j + 1][k]), dp[i][j][k + 1]);
                }
            }
        }
        System.out.println(dp[0][0][0]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        String str2 = scn.next();
        String str3 = scn.next();
        scn.close();
        solution(str1, str2, str3);
    }

}