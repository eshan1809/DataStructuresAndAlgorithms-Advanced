/*
1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
*/

import java.util.*;

public class smallestSubstringAStringContainingAllCharactersOfAnotherString {
    public static String solution(String s1, String s2) {
        // write your code here
        String ans = "";
        Map<Character, Integer> freq1 = new HashMap<>(), freq2 = new HashMap<>();
        int mc = 0, rmc = s2.length(), i = -1, j = -1;
        for (int k = 0; k < rmc; k++)
            freq2.put(s2.charAt(k), freq2.getOrDefault(s2.charAt(k), 0) + 1);
        while (true) {
            int flag = 0;
            while (j < s1.length() - 1 && mc < rmc) {
                j++;
                char ch = s1.charAt(j);
                freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
                if (freq1.getOrDefault(ch, 0) <= freq2.getOrDefault(ch, 0))
                    mc++;
                flag++;
            }
            while (i < j && mc == rmc) {
                i++;
                String cans = s1.substring(i, j + 1);
                if (ans.length() == 0 || cans.length() < ans.length())
                    ans = cans;
                char ch = s1.charAt(i);
                if (freq1.get(ch) == 1)
                    freq1.remove(ch);
                else
                    freq1.put(ch, freq1.get(ch) - 1);
                if (freq1.getOrDefault(ch, 0) < freq2.getOrDefault(ch, 0))
                    mc--;
                flag++;
            }
            if (flag == 0)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
        scn.close();
    }

}
