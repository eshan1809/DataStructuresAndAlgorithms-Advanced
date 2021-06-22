/*
We can scramble a string s to get a string t using the following algorithm:

1) If the length of the string is 1, stop.
2) If the length of the string is > 1, do the following:
    > Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
    
    > Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
    
    > Apply step 1 recursively on each of the two substrings x and y.

Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
*/

import java.io.*;
import java.util.*;

public class scrambleString {

    public static boolean helper(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {
        if (dp[si1][si2][len] != null)
            return dp[si1][si2][len];

        if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len))) {
            dp[si1][si2][len] = true;
            return true;
        }

        for (int i = 1; i < len; i++) {
            if ((helper(s1, s2, si1, si2, i, dp) && helper(s1, s2, si1 + i, si2 + i, len - i, dp))
                    || (helper(s1, s2, si1, si2 + len - i, i, dp) && helper(s1, s2, si1 + i, si2, len - i, dp))) {
                dp[si1][si2][len] = true;
                return true;
            }
        }
        dp[si1][si2][len] = false;
        return false;
    }

    public static boolean isScrambleTab(String s1, String s2) {
        // write your code here
        int n = s1.length();
        if (n != s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : s2.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
            } else
                return false;
        }
        return helper(s1, s2, 0, 0, n, new Boolean[n][n][n + 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        System.out.println(isScrambleTab(s1, s2));
    }
}
