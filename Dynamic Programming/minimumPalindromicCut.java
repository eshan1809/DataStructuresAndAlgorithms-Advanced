/*
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
*/

import java.util.*;

public class minimumPalindromicCut {

    public static int minPalindromicCut(String s) {
        // write your code here
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0)
                    dp[i][j] = true;
                else if (k == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
            }
        }

        int[] dp2 = new int[n];
        for (int j = 1; j < n; j++) {
            if (dp[0][j])
                continue;
            int min = n;
            for (int i = j; i >= 1; i--) {
                if (dp[i][j])
                    min = Math.min(min, dp2[i - 1]);
            }
            dp2[j] = min + 1;
        }
        return dp2[n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut(str));
    }
}