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
        int n = s.length(), m = p.length();
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> pmap = new HashMap<>(), smap = new HashMap<>();
        for (char ch : p.toCharArray())
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        for (int i = 0; i < m - 1; i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        for (int i = m - 1; i < n; i++) {
            char ch1 = s.charAt(i);
            smap.put(ch1, smap.getOrDefault(ch1, 0) + 1);
            if (pmap.size() == smap.size()) {
                int flag = 0;
                for (char ch : pmap.keySet()) {
                    if (!smap.containsKey(ch) || smap.get(ch) != pmap.get(ch)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    list.add(i - m + 1);
            }
            char ch2 = s.charAt(i - m + 1);
            if (smap.get(ch2) == 1)
                smap.remove(ch2);
            else
                smap.put(ch2, smap.get(ch2) - 1);
        }
        System.out.println(list.size());
        for (int i : list)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();
        scn.close();
        findAnagrams(s, p);
    }
}
