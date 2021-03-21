/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k characters out of the word.
*/

import java.io.*;
import java.util.*;

public class Words_K_Selection4 {
    public static void generateSelection(int cs, int ts, String ustr, HashMap<Character, Integer> unique, int ls,
            String asf) {
        if (cs > ts) { // base case when we have occupied all cells
            System.out.println(asf); // print ans
            return;
        }

        for (int i = ls; i < ustr.length(); i++) { // we choose characters for this cell
            char ch = ustr.charAt(i); // choose a char one by one
            int f = unique.get(ch); // note down its frequency
            if (f > 0) { // if it is atleast one
                unique.put(ch, f - 1); // decrease by one
                generateSelection(cs + 1, ts, ustr, unique, i, asf + ch); // call for next level
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
        generateSelection(1, k, ustr, unique, 0, "");
    }
}
