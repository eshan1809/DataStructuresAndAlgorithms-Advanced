/*
1. You are given a number N.
2. You have to find Nth ugly number.
3. Ugly number is defined as the number whose prime factors are only 2,3 and 5.  
4. First eleven ugly numbers are -> 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.

Assumption -> 1 is the first ugly number.
*/

import java.io.*;
import java.util.*;

public class uglyNumber {
    public static int solution(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int f2 = 2 * dp[p2], f3 = 3 * dp[p3], f5 = 5 * dp[p5];
            dp[i] = Math.min(f2, Math.min(f3, f5));
            if (dp[i] == f2)
                p2++;
            if (dp[i] == f3)
                p3++;
            if (dp[i] == f5)
                p5++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }
}
