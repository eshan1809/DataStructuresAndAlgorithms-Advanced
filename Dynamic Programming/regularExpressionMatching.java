/*
1. You are given two strings S1 and S2. S1 represents a text and S2 represents a pattern.
2. You have to print 'true' if the pattern is matched with the given text, otherwise print 'false'.

The pattern can include the characters '.' and '*'
'.' - matches any single character
'*' - matches zero or more of the preceding character
*/

import java.util.*;

public class regularExpressionMatching {
    public static boolean solution(String s, String p) {
        // write your code here
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (i - 2 >= 0 && p.charAt(i - 1) == '*')
                dp[i][0] = dp[i - 2][0];
        }
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*') {
                    if (dp[i - 2][j])
                        dp[i][j] = true;
                    else
                        dp[i][j] = (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') && dp[i][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
        scn.close();
    }
}
