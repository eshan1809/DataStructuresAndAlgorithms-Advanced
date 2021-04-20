/*
1. You are given a string str.
2. You are required to print the length of longest of palindromic substrings in string str.
*/

import java.util.*;

public class longestPalindromicSubstring {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int max = 0;
        for (int k = 0; k < dp.length; k++) {
            for (int i = 0, j = k; i < dp.length && j < dp.length; i++, j++) {
                boolean flag = false;
                if (k == 0)
                    flag = true;
                else if (k == 1 && str.charAt(i) == str.charAt(j))
                    flag = true;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1])
                    flag = true;
                if (flag) {
                    dp[i][j] = true;
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        System.out.println(max);
    }
}