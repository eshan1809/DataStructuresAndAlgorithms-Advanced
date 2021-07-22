/*
1. You are given a number N.
2. You have to find the minimum number of operations needed to reduce it to 1.
3. operations allowed are - 
   -> If n is divisible by 2 then you may reduce n to n/2.
   -> If n is divisible by 3 then you may reduce n to n/3.
   -> Decrement n by 1.
*/

import java.util.*;

public class minimumNumberOfStepsToReduceN {
    public static int solution(int n) {
        // write your code here
        if (n == 1)
            return 0;
        if (n < 4)
            return 1;
        int[] dp = new int[n + 1];
        dp[3] = dp[2] = 1;
        for (int i = 4; i <= n; i++) {
            int min = dp[i - 1];
            if (i % 3 == 0)
                min = Math.min(min, dp[i / 3]);
            if (i % 2 == 0)
                min = Math.min(min, dp[i / 2]);
            dp[i] = min + 1;
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