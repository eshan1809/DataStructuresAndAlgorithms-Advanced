/*
(V.C.P.D)Vice City Police Department have upgraded their security system.
Security System is very capable of detecting a houseRobbery, but it has a fundamental flaw. Tommy is in need for quick cash & wants your help in robbing houses. Help him gather as much money from robbing houses by exploiting the flaw.
The flaw in the Security System upgrade is that It immediatly detects a houseRobbery only if two consecutive houses are robbed.
"Find how much money can Tommy earn over-night by exploiting Security System flaw ?"

NOTE : Watch Question video to get better understanding of problem.
Example  : 
    Input : arr = [1,2,3,4,5,6]
    Output : 12
    Explanation : Value in input arr represents amount generated after respective house - robbey & Tommy must rob second,fourth & sixth house to generate maximum income.
*/

import java.util.Scanner;

public class houseRobber {
    public static int Solve(int inp[]) {
        int n = inp.length;
        int[][] dp = new int[2][n];
        dp[0][0] = 0;
        dp[1][0] = inp[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = inp[i] + dp[0][i - 1];
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int inp[] = new int[n];

        for (int i = 0; i < n; i++) {
            inp[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(Solve(inp));
    }
}
