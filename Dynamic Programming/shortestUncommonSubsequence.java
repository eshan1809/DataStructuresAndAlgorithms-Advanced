/*
1. You are given two strings S1 and S2.
2. You have to find length of the shortest subsequence in S1 which is not a subsequence in S2. 
3. If no such subsequence exists, then print '-1'.
*/

import java.util.*;

public class shortestUncommonSubsequence {

    public static int solution(String s1, String s2) {
        // write your code here
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++)
            dp[0][i] = 1001;
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int k = j;
                while (k > 0 && s2.charAt(k - 1) != s1.charAt(i - 1))
                    k--;
                if (k == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k - 1] + 1);
            }
        }
        return dp[n][m] >= 1001 ? -1 : dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        System.out.println(solution(s1, s2));
    }

}