/*
1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.
*/

import java.util.*;

public class wordPattern {
    public static boolean answer(String pattern, String str) {
        // write your code here
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        for (int i = 0; i < pattern.length() && i < strs.length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i]))
                    return false;
            } else {
                if (set.contains(strs[i]))
                    return false;
                map.put(ch, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        scn.close();
        System.out.println(answer(pattern, words));
    }
}
