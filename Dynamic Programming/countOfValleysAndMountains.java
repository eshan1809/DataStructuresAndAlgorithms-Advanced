/*
1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.
<img src="https://pepcoding.com/resources/ojquestionresource/images/countvalleys2.JPG" />
countvalleys

Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
*/

import java.io.*;
import java.util.*;

public class countOfValleysAndMountains {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int f = 0, l = i - 1, v = 0;
            while (f < l)
                v += 2 * dp[f++] * dp[l--];
            if (f == l)
                v += dp[f] * dp[f];
            dp[i] = v;
        }
        System.out.println(dp[n]);
    }
}
