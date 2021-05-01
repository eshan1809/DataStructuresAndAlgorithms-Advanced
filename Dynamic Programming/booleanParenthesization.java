/*
1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
*/

import java.util.*;

public class booleanParenthesization {
    public static class Pair {
        int t, f;

        Pair() {
        }

        Pair(int t, int f) {
            this.t = t;
            this.f = f;
        }
    }

    public static int solution(String str1, String str2) {
        // write your code here
        int n = str1.length();
        Pair[][] dp = new Pair[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0) {
                    if (str1.charAt(i) == 'T')
                        dp[i][j] = new Pair(1, 0);
                    else
                        dp[i][j] = new Pair(0, 1);
                } else if (k == 1) {
                    char ch = str2.charAt(i), ch1 = str1.charAt(i), ch2 = str1.charAt(j);
                    if (ch == '&') {
                        if (ch1 == 'T' && ch2 == 'T')
                            dp[i][j] = new Pair(1, 0);
                        else
                            dp[i][j] = new Pair(0, 1);
                    } else if (ch == '|') {
                        if (ch1 == 'F' && ch2 == 'F')
                            dp[i][j] = new Pair(0, 1);
                        else
                            dp[i][j] = new Pair(1, 0);
                    } else {
                        if (ch1 != ch2)
                            dp[i][j] = new Pair(1, 0);
                        else
                            dp[i][j] = new Pair(0, 1);
                    }
                } else {
                    int not = 0, nof = 0;
                    for (int x = i; x < j; x++) {
                        char ch = str2.charAt(x);
                        int x1 = dp[i][x].t, x2 = dp[i][x].f, x3 = dp[x + 1][j].t, x4 = dp[x + 1][j].f;
                        if (ch == '&') {
                            not = not + x1 * x3;
                            nof = nof + x1 * x4 + x2 * x3 + x2 * x4;
                        } else if (ch == '|') {
                            not = not + x1 * x3 + x1 * x4 + x2 * x3;
                            nof = nof + x2 * x4;
                        } else {
                            not = not + x1 * x4 + x2 * x3;
                            nof = nof + x1 * x3 + x2 * x4;
                        }
                    }
                    dp[i][j] = new Pair(not, nof);
                }
            }
        }
        return dp[0][n - 1].t;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        System.out.println(solution(s1, s2));
    }

}
