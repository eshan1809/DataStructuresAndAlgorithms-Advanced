/*
1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.
*/

import java.util.*;

public class Cryptarithmetic {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
        scn.close();
    }

    public static int getnum(String s, HashMap<Character, Integer> charIntMap) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num += charIntMap.get(ch);
        }
        return Integer.parseInt(num);
    }

    public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
            String s1, String s2, String s3) {
        if (unique.length() == idx) {
            int sum1 = getnum(s1, charIntMap), sum2 = getnum(s2, charIntMap), sum3 = getnum(s3, charIntMap);
            if (sum1 + sum2 == sum3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);
        for (int i = 0; i < 10; i++) {
            if (usedNumbers[i] == false) {
                charIntMap.put(ch, i);
                usedNumbers[i] = true;
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[i] = false;
                charIntMap.put(ch, -1);
            }
        }
    }

}