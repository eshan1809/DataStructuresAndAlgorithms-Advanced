/*
1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if 
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other. 

Note -> Both s1 ad s2 consist of lowercase English letters only.
*/

import java.util.*;

public class k_Anagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        // write your code here
        int n = str1.length(), m = str2.length(), count = 0;
        if (n != m)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : str2.toCharArray()) {
            if (map.containsKey(ch)) {
                int x = map.get(ch);
                if (x == 1)
                    map.remove(ch);
                else
                    map.put(ch, x - 1);
            } else
                count++;
        }
        return count <= k;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        String str2 = scn.next();
        int k = scn.nextInt();
        scn.close();
        System.out.println(areKAnagrams(str1, str2, k));

    }
}
