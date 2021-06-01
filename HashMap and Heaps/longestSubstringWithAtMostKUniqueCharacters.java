/*
1. You are given a string(str) and a number K.
2. You have to find the length of longest substring of the given string that contains at most K unique characters.
*/

import java.util.*;

public class longestSubstringWithAtMostKUniqueCharacters {
    public static int solution(String str, int k) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (true) {
            int flag = 0;
            while (j < str.length() && map.size() <= k) {
                ans = Math.max(ans, j - i);
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                j++;
                flag++;
            }
            while (i < str.length() && map.size() > k) {
                char ch = str.charAt(i);
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
                i++;
                flag++;
            }
            if (flag == 0)
                break;
        }
        ans = Math.max(ans, j - i);
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
