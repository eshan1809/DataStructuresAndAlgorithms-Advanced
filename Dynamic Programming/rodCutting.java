/*
1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to 
     N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.
*/

import java.util.*;

public class rodCutting {
    public static int solution(int[] prices) {
        // write your code here
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        for (int i = 1; i < n; i++) {
            int max = prices[i];
            for (int j = 0; j < (i + 1) / 2; j++) {
                max = Math.max(max, dp[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(prices));
    }
}
