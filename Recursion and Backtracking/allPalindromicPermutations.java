/*
1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "-1".
*/

import java.util.*;

public class allPalindromicPermutations {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs == ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String ans = asf;
            if (oddc != null) {
                ans += oddc;
            }
            ans += rev;
            System.out.println(ans);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        scn.close();

        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 == 1) {
                odds++;
                odd = ch;
            }
            fmap.put(ch, freq / 2);
            len += freq / 2;
        }
        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        generatepw(0, len, fmap, odd, "");
    }

}