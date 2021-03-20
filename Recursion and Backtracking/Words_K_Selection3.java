/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k characters out of the word.
*/

import java.io.*;
import java.util.*;

public class Words_K_Selection3 {

    public static void generateWords(int cc, String str, int n, HashMap<Character, Integer> unique, String asf) {
        if (n < 0)
            return;
        if (n == 0) {
            System.out.println(asf);
            return;
        }
        if (cc == str.length())
            return;

        char ch = str.charAt(cc);
        for (int i = unique.get(ch); i > 0; i--) {
            char[] fasf = new char[i];
            Arrays.fill(fasf, ch);
            generateWords(cc + 1, str, n - i, unique, asf + new String(fasf));
        }
        generateWords(cc + 1, str, n, unique, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.containsKey(ch)) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        generateWords(0, ustr, k, unique, "");
    }
}
