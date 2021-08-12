/*
1. Pepcoder arranged some glasses in the form of pascal triangle.
2. Capacity of each glass is 1 litre. If you pour K amount of water in a glass, it will retain 1 litre and
   rest of it gets equally distributed in left bottom glass and right bottom glass.
3. If pepcoder pours K litres of water in the topmost glass, you have to find out the amount of water in Cth glass of Rth row.

Assumption -> There are enough glasses in the triangle till no glass overflows.
*/

import java.util.*;

public class findWaterInGlass {
    public static double solution(int k, int r, int c) {
        // write your code here
        double[][] dp = new double[r + 1][c + 1];
        dp[0][0] = k;
        for (int i = 1; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (dp[i - 1][j] > 1)
                    dp[i][j] = (dp[i - 1][j] - 1) / 2;
                if (j > 0 && dp[i - 1][j - 1] > 1)
                    dp[i][j] += (dp[i - 1][j - 1] - 1) / 2;
            }
        }
        return dp[r][c] > 1 ? 1.0 : dp[r][c];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        scn.close();
        System.out.println(solution(k, r, c));
    }
}
