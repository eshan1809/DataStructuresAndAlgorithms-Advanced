/*
1. You are given a string.
2. You have to print the count of distinct and non-empty subsequences of the given string. 

Note -> String contains only lowercase letters.
*/

import java.util.*;

public class countDistinctSubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        Map<Character, Integer> prev = new HashMap<>();
        for (int i = 1; i < str.length() + 1; i++) {
            char ch = str.charAt(i - 1);
            dp[i] = dp[i - 1] * 2;
            if (prev.containsKey(ch))
                dp[i] -= dp[prev.get(ch) - 1];
            prev.put(ch, i);
        }
        System.out.println(dp[str.length()] - 1);
    }
}
