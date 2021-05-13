/*
1. You are given two strings S1 and S2.
2. You have to make these two strings equal by deleting characters. You can delete characters from any of the two strings.
3. The cost of deleting a character from any string is the ASCII value of that character.
4. You have to find the minimum ASCII sum of deleted characters.
*/

import java.io.*;
import java.util.*;

public class minimumAsciiDeleteSumForTwoStrings {

    public static int solution(String s1, String s2) {
        // write your code here
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = m - 1; i >= 0; i--)
            dp[n][i] = dp[n][i + 1] + (int) s2.charAt(i);
        for (int i = n - 1; i >= 0; i--)
            dp[i][m] = dp[i + 1][m] + (int) s1.charAt(i);
        for (int i = n - 1; i >= 0; i--) {
            char ch1 = s1.charAt(i);
            for (int j = m - 1; j >= 0; j--) {
                char ch2 = s2.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min((int) ch1 + dp[i + 1][j], (int) ch2 + dp[i][j + 1]);
                }
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