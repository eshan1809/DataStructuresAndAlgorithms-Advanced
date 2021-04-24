/*
1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
*/

import java.util.*;

public class numberOfWaysOfTriangulation {
    public static int solution(int n) {
        // write your code here
        if (n <= 3)
            return 1;
        int[] dp = new int[n - 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n - 1; i++) {
            int f = 0, l = i - 1, v = 0;
            while (f < l)
                v += 2 * dp[f++] * dp[l--];
            if (f == l)
                v += dp[f] * dp[f];
            dp[i] = v;
        }
        return dp[n - 2];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
        scn.close();
    }
}
