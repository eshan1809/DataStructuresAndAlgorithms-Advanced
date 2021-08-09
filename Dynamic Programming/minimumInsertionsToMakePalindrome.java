/*
1. You are given a string(str).
2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.
*/

import java.util.*;

public class minimumInsertionsToMakePalindrome {
    public static int solution(String str) {
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
        String str = scn.next();
        scn.close();
        System.out.println(solution(str));
    }
}
