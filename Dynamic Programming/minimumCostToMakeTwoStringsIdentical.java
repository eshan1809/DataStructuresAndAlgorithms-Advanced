/*
1. You are given two strings S1, S2, and two numbers x and y.
2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
3. You can delete characters from both the strings.
4. You have to find the minimum cost required to make the given two strings identical.
*/

import java.io.*;
import java.util.*;

public class minimumCostToMakeTwoStringsIdentical {
    public static int solution(String s1, String s2, int c1, int c2) {
        // write your code here
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = m - 1; i >= 0; i--)
            dp[n][i] = dp[n][i + 1] + c2;
        for (int i = n - 1; i >= 0; i--)
            dp[i][m] = dp[i + 1][m] + c1;
        for (int i = n - 1; i >= 0; i--) {
            char ch1 = s1.charAt(i);
            for (int j = m - 1; j >= 0; j--) {
                char ch2 = s2.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(c1 + dp[i + 1][j], c2 + dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int x = scn.nextInt();
        int y = scn.nextInt();
        System.out.println(solution(s1, s2, x, y));
    }
}
