/*
1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.
*/

import java.util.*;

public class validAnagram {
    public static boolean solution(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        for (int i = 0; i < s2.length(); i++)
            if (hm.getOrDefault(s2.charAt(i), 0) == 0)
                return false;
            else
                hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
        for (char i : hm.keySet())
            if (hm.get(i) != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        scn.close();
        System.out.println(solution(s1, s2));
    }
}
