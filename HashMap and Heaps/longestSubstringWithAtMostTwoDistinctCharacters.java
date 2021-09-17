
/*
Given a string s, return the length of the longest substring that contains at most two distinct characters.
*/
import java.util.*;

public class longestSubstringWithAtMostTwoDistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > 2) {
                char ch2 = s.charAt(i);
                int freq = map.get(ch2);
                if (freq == 1)
                    map.remove(ch2);
                else
                    map.put(ch2, freq - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int ans = lengthOfLongestSubstringTwoDistinct(scn.nextLine());
        scn.close();
        System.out.println(ans);
    }
}
