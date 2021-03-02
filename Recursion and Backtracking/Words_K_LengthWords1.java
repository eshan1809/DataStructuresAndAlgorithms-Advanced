/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the word.
*/

import java.io.*;
import java.util.*;

public class Words_K_LengthWords1 {

    public static void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {
        if (cc == ustr.length()) {
            if (ssf == ts) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(cc);
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                generateWords(cc + 1, ustr, ssf + 1, ts, spots);
                spots[i] = null;
            }
        }
        generateWords(cc + 1, ustr, ssf, ts, spots);
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

        Character[] spots = new Character[k];
        generateWords(0, ustr, 0, k, spots);
    }

}
