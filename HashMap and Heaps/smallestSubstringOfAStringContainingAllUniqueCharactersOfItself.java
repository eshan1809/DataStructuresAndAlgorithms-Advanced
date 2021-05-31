/*
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
*/

import java.util.*;

public class smallestSubstringOfAStringContainingAllUniqueCharactersOfItself {
    public static int solution(String str) {
        // write your code here
        int ans = str.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < str.length() - set.size() + 1; i++) {
            for (; j < str.length(); j++) {
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == set.size()) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
            if (ans == set.size())
                break;
            char ch = str.charAt(i);
            if (map.get(ch) == 1)
                map.remove(ch);
            else
                map.put(ch, map.get(ch) - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
        scn.close();
    }
}
