/*
1. You are given a string(str) consisting of only 0's and 1's, and a number N.
2. You have to find if the binary representation of every number from 1 to N can be represented by a substring of the given string.
*/

import java.util.*;

public class binaryStringWithSubstringsRepresentingNumbersFrom1ToN {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(str, n));
    }

    public static boolean solution(String str, int n) {
        // write your code here
        int N = str.length();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 0)
                continue;
            for (int j = i + 1; j <= N; j++)
                if (j - i < 32)
                    set.add(Integer.parseInt(str.substring(i, j), 2));
                else
                    break;
        }
        if (set.size() < n)
            return false;
        for (int i = 1; i <= n; i++)
            if (!set.contains(i))
                return false;
        return true;
    }

}
