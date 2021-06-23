/*
1. You are given a string of characters(a-z,A-Z).
2. Find the minimum number of deletions/removals needed such that remaining characters are palindromic.
*/

import java.util.Scanner;

public class minimumDeletionsToMakePalindromicSequence {
    public static int minimumDeletionsToPalindrome(String str) {
        // write your code here
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int k = 1; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        System.out.println(minimumDeletionsToPalindrome(str));
    }
}
