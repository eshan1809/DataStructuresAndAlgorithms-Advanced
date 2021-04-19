/*
1. You are given a number N.
2. You have to find the minimum number of squares that sum to N.
3. You can always represent a number as a sum of squares of other numbers.
   For eg -> In worst case N can be represented as (1*1) + (1*1) + (1*1)..... N times.
*/

import java.util.*;

public class minSquares {

    public static int solution(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = 1, sq = 1, min = Integer.MAX_VALUE;
            while (i - sq >= 0) {
                min = Math.min(dp[i - sq] + 1, min);
                x++;
                sq = x * x;
            }
            dp[i] = min;
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