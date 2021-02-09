/*
1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular expressions.
*/

import java.util.*;

public class patternMatching {

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        if (pattern.length() == 0) {
            if (str.length() == 0) {
                Set<Character> ap = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if (!ap.contains(ch)) {
                        ap.add(ch);
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rp = pattern.substring(1);
        if (map.containsKey(ch)) {
            String ps = map.get(ch);
            if (str.length() >= ps.length()) {
                String cs = str.substring(0, ps.length());
                String rs = str.substring(ps.length());
                if (cs.equals(ps)) {
                    solution(rs, rp, map, op);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String ms = str.substring(0, i + 1);
                String rs = str.substring(i + 1);
                map.put(ch, ms);
                solution(rs, rp, map, op);
                map.remove(ch);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, pattern);
        scn.close();
    }
}