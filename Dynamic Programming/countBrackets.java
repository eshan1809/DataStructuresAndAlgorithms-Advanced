/*
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
*/

import java.util.*;

public class countBrackets {
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
