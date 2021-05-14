/*
1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.
*/

import java.io.*;
import java.util.*;

public class distinctTransformations {
    public static int solution(String s, String t) {
        // write your code here
        int n = t.length(), m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++)
            dp[n][i] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (t.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
                else
                    dp[i][j] = dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
