/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the word.
*/

import java.io.*;
import java.util.*;

public class Words_K_LengthWords2 {

    public static void generateWords(int cs, int ts, String ustr, HashSet<Character> used, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if (!used.contains(ch)) {
                used.add(ch);
                generateWords(cs + 1, ts, ustr, used, asf + ch);
                used.remove(ch);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateWords(1, k, ustr, new HashSet<>(), "");
    }

}
