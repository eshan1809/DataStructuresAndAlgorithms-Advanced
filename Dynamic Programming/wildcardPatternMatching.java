/*
1. You are given two strings S1 and S2. S1 represents a text and S2 represents a wildcard pattern.
2. You have to print 'true' if the wildcard pattern is matched with the given text, otherwise print 'false'.

The wildcard pattern can include the characters '?' and '*'
'?' - matches any single character
'*' - matches any sequence of characters (including the empty sequence)
*/

import java.io.*;
import java.util.*;

public class wildcardPatternMatching {
    public static boolean solution(String str, String pattern) {
        // write your code here
        int n = pattern.length(), m = str.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        int i = n - 1;
        while (i >= 0 && pattern.charAt(i) == '*')
            dp[i--][m] = true;
        for (i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                char ch = pattern.charAt(i);
                if (ch == '*') {
                    for (int x = j; x <= m; x++)
                        if (dp[i + 1][x]) {
                            dp[i][j] = true;
                            break;
                        }
                } else if (ch == '?')
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = ch == str.charAt(j) && dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
        scn.close();
    }
}
