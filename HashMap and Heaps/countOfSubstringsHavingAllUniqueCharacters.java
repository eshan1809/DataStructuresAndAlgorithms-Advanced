/*
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
*/

import java.util.*;

public class countOfSubstringsHavingAllUniqueCharacters {
    public static int solution(String str) {
        // write your code here
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (set.contains(ch))
                    break;
                set.add(ch);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
        scn.close();
    }
}
