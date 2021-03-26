/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.
*/

import java.io.*;
import java.util.*;

public class Words_K_LengthWords4 {
    public static void generateWords(int cs, int ts, String ustr, HashMap<Character, Integer> unique, String asf) {
        if (cs > ts) { // when we fill all boxes
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < ustr.length(); i++) { // for this box we choose
            char ch = ustr.charAt(i); // each characters one by one
            int f = unique.get(ch); // note down it's frequency
            if (f > 0) { // if it is present atleast once
                unique.put(ch, f - 1); // update the freq
                generateWords(cs + 1, ts, ustr, unique, asf + ch); // call for next lavel
                unique.put(ch, f); // undo while backtracking
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        generateWords(1, k, ustr, unique, "");
    }
}
