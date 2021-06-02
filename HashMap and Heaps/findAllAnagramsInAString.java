/*
1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only.
*/

import java.util.*;

public class findAllAnagramsInAString {
    public static void findAnagrams(String s, String p) {
        // write your code here

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();
        scn.close();
        findAnagrams(s, p);
    }
}
