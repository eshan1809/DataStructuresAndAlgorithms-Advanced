/*
1. You are given a string that represents an expression containing numbers and two operators + and *.
2. You have to find the minimum and maximum value which can be obtained by evaluating this expression by different parenthesization.

Constraints:
1 <= length of string <= 100
Range of numbers -> [0,9]

Sample Input
1+2*3+4*5

Sample Output
Minimum Value -> 27
Maximum Value -> 105
*/

import java.util.*;

public class MinMaxValueExpression {

    public static int[] solution(String str1, String str2) {
        // write your code here
        int[] ans = new int[2];
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[m + 1][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0)
                    dp[i][j] = str1.charAt(j) - '0';
                else if (k == 1) {
                    int a = str1.charAt(i) - '0', b = str1.charAt(j) - '0';
                    if (str2.charAt(i) == '+')
                        dp[i][j] = a + b;
                    else
                        dp[i][j] = a * b;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int x = i; x < j; x++) {
                        if (str2.charAt(x) == '+')
                            min = Math.min(min, dp[i][x] + dp[x + 1][j]);
                        else
                            min = Math.min(min, dp[i][x] * dp[x + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }

        ans[0] = dp[0][n - 1];

        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0)
                    dp[i][j] = str1.charAt(j) - '0';
                else if (k == 1) {
                    int a = str1.charAt(i) - '0', b = str1.charAt(j) - '0';
                    if (str2.charAt(i) == '+')
                        dp[i][j] = a + b;
                    else
                        dp[i][j] = a * b;
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int x = i; x < j; x++) {
                        if (str2.charAt(x) == '+')
                            max = Math.max(max, dp[i][x] + dp[x + 1][j]);
                        else
                            max = Math.max(max, dp[i][x] * dp[x + 1][j]);
                    }
                    dp[i][j] = max;
                }
            }
        }

        ans[1] = dp[0][n - 1];

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*') {
                str2 += ch;
            } else {
                str1 += ch;
            }
        }
        scn.close();
        int[] arr = solution(str1, str2);
        System.out.println("Minimum Value -> " + arr[0]);
        System.out.println("Maximum Value -> " + arr[1]);
    }

}