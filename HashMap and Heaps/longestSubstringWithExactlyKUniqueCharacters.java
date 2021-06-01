/*
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
*/

import java.util.*;

public class longestSubstringWithExactlyKUniqueCharacters {
    public static int solution(String str, int k) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (true) {
            int flag = 0;
            while (j < str.length()) {
                flag++;
                char ch = str.charAt(j);
                if (map.containsKey(ch) || map.size() < k) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    j++;
                } else {
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
            while (i < str.length()) {
                flag++;
                char ch = str.charAt(i++);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                    break;
                }
                map.put(ch, map.get(ch) - 1);
            }
            if (flag == 0)
                break;
        }
        return ans == 0 ? str.length() : ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(str, k));
    }
}
