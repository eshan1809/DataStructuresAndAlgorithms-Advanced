/*
1. You are given a number n.
2. You are required to find the value of nth catalan number.
C0 -> 1
C1 -> 1
C2 -> 2
C3 -> 5
..
Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0
*/

import java.io.*;
import java.util.*;

public class catalanNumber {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int f = 0, l = i - 1, v = 0;
            while (f < l)
                v += 2 * dp[f++] * dp[l--];
            if (f == l)
                v += dp[f] * dp[f];
            dp[i] = v;
        }
        System.out.println(dp[n]);
    }
}
