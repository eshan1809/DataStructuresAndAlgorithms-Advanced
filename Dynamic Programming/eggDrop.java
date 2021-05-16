/*
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
*/

import java.io.*;
import java.util.*;

public class eggDrop {
    public static int eggDrop(int n, int k) {
        // write your code here
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i < k + 1; i++)
            dp[0][i] = i;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int x = Integer.MAX_VALUE;
                for (int t = 0; t < j; t++)
                    x = Math.min(x, Math.max(dp[i - 1][t], dp[i][j - 1 - t]));
                dp[i][j] = x + 1;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n, k));
    }
}
