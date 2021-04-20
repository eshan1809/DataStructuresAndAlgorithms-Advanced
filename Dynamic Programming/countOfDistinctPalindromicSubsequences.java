/*
1. You are given a string.
2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.

Note  -> String contains only lowercase letters.
      -> The answer will be in the integer range only.
*/

import java.util.*;

public class countOfDistinctPalindromicSubsequences {
    public static int solution(String str) {
        // write your code here
        int[][] dp = new int[str.length()][str.length()];
        for (int k = 0; k < dp.length; k++) {
            for (int i = 0, j = k; i < dp.length && j < dp.length; i++, j++) {
                if (k == 0)
                    dp[i][j] = 1;
                else if (k == 1)
                    dp[i][j] = 2;
                else {
                    if (str.charAt(i) == str.charAt(j)) {
                        int b = i;
                        char ch = str.charAt(i);
                        while (++b < j) {
                            if (str.charAt(b) == ch)
                                break;
                        }
                        if (b == j)
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        else {
                            int e = j;
                            while (--e >= b) {
                                if (str.charAt(e) == ch)
                                    break;
                            }
                            if (b == e)
                                dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                            else
                                dp[i][j] = 2 * dp[i + 1][j - 1] - dp[b + 1][e - 1];
                        }
                    } else
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        System.out.println(solution(str));
    }
}
