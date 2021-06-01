/*
1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.
*/

import java.util.*;

public class countOfSubstringsWithExactlyKUniqueCharacters {
    public static int solution(String str, int k) {
        // write your code here
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                set.add(ch);
                if (set.size() == k)
                    ans++;
                else if (set.size() > k)
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(str, k));
    }
}
