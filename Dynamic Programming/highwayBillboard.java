/*
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
*/

import java.util.Scanner;

public class highwayBillboard {
    public static int solution(int m, int[] x, int[] rev, int t) {
        // write your code here
        int[] arr = new int[m + 1], dp = new int[m + 1];
        for (int i = 0; i < x.length; i++) {
            arr[x[i]] = rev[i];
        }
        dp[0] = arr[0];
        for (int i = 1; i < m + 1; i++) {
            if (i <= t) {
                dp[i] = Math.max(arr[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - t - 1]);
            }
        }
        return dp[m];
    }

    public static void input(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
