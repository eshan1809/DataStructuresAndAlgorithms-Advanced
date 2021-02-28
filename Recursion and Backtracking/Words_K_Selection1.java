/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k distinct characters out of the word
*/

import java.io.*;
import java.util.*;

public class Words_K_Selection1 {
    public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
        if (ssf == ts) {
            System.out.println(asf);
            return;
        }
        if (i == ustr.length()) {
            return;
        }
        char ch = ustr.charAt(i);
        generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
        generateSelection(i + 1, ustr, ssf, ts, asf);
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

        generateSelection(0, ustr, 0, k, "");
    }
}
