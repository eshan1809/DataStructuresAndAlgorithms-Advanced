/*
1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
*/

import java.util.*;

public class longestSubstringWithNonRepeatingCharacters {
    public static int solution(String str) {
        // write your code here
        Set<Character> set = new HashSet<>();
        int ans = 1, i = 0;
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            while (set.contains(ch))
                set.remove(str.charAt(i++));
            set.add(ch);
            ans = Math.max(ans, j - i + 1);
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
