/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
*/

import java.io.*;
import java.util.*;

public class printAllResultsIn_0_1_Knapsack {
    public static class Pair {
        int i, j;
        String psf;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        // write your code here
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                dp[i][j] = dp[i - 1][j];
                if (wts[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i][j], values[i - 1] + dp[i - 1][j - wts[i - 1]]);
            }
        }
        System.out.println(dp[n][cap]);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, cap, ""));

        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.i == 0 || p.j == 0)
                System.out.println(p.psf);
            else {
                int x = p.j - wts[p.i - 1];
                if (x >= 0 && dp[p.i][p.j] - values[p.i - 1] == dp[p.i - 1][x])
                    q.add(new Pair(p.i - 1, p.j - wts[p.i - 1], (p.i - 1) + " " + p.psf));
                if (dp[p.i][p.j] == dp[p.i - 1][p.j])
                    q.add(new Pair(p.i - 1, p.j, p.psf));
            }
        }
    }
}
