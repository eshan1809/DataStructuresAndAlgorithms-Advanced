/*
1. You are given three strings - s1, s2 and s3.
2. You have to find whether s3 is formed by interleaving of s1 and s2.
3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.
*/

import java.util.*;

public class interleavingOfTwoStrings {
    public static boolean helper(String s1, String s2, String s3, int si1, int si2, int si3, Boolean[][][] dp) {
        if (dp[si1][si2][si3] != null)
            return dp[si1][si2][si3];

        if (si3 == s3.length()) {
            dp[si1][si2][si3] = true;
            return true;
        }

        if (si1 == s1.length()) {
            dp[si1][si2][si3] = s3.substring(si3).equals(s2.substring(si2));
            return dp[si1][si2][si3];
        }

        if (si2 == s2.length()) {
            dp[si1][si2][si3] = s3.substring(si3).equals(s1.substring(si1));
            return dp[si1][si2][si3];
        }

        if (s1.charAt(si1) == s3.charAt(si3) && helper(s1, s2, s3, si1 + 1, si2, si3 + 1, dp)) {
            dp[si1][si2][si3] = true;
            return true;
        }
        if (s2.charAt(si2) == s3.charAt(si3) && helper(s1, s2, s3, si1, si2 + 1, si3 + 1, dp)) {
            dp[si1][si2][si3] = true;
            return true;
        }
        dp[si1][si2][si3] = false;
        return false;
    }

    public static boolean solution(String s1, String s2, String s3) {
        // write your code here
        int n = s1.length(), m = s2.length();
        if (s3.length() != n + m)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : s2.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : s3.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
            } else
                return false;
        }
        return helper(s1, s2, s3, 0, 0, 0, new Boolean[n + 1][m + 1][n + m + 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        scn.close();
        System.out.println(solution(s1, s2, s3));
    }
}
