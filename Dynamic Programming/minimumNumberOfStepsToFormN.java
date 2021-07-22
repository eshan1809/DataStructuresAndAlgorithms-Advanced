/*
1. You are given a number N.
2. You have to find the minimum number of operations needed to to reach N from 0.
3. operations allowed are - 
   -> Double the number.
   -> Add one to the number.
*/

import java.util.*;

public class minimumNumberOfStepsToFormN {

    public static int solution(int n) {
        // write your code here
        if (n < 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = dp[i - 1];
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