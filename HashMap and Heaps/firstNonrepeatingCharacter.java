/*
1. You are given a string.
2. You have to find the index of the first non-repeating character in the given string.
3. If no such character exists, print "-1".
*/

import java.util.*;

public class firstNonrepeatingCharacter {
    public static int solution(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                if (map.containsKey(ch)) {
                    set.add(ch);
                    map.remove(ch);
                } else {
                    map.put(ch, i);
                }
            }
        }
        int min = s.length();
        for (char ch : map.keySet())
            min = Math.min(min, map.get(ch));
        return min < s.length() ? min : -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.close();
        System.out.print(solution(s));
    }
}
