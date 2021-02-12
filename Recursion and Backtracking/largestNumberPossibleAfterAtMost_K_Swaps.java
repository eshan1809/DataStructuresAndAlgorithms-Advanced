/*
1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.
*/

import java.util.*;

public class largestNumberPossibleAfterAtMost_K_Swaps {

    static String max;

    public static void findMaximum(String str, int k) {
        if (Integer.parseInt(str) > Integer.parseInt(max)) {
            max = str;
        }
        if (k == 0) {
            return;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    String ss = swap(str, i, j);
                    findMaximum(ss, k - 1);
                }
            }
        }

    }

    public static String swap(String str, int i, int j) {
        char chi = str.charAt(i);
        char chj = str.charAt(j);
        String left = str.substring(0, i);
        String mid = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        return left + chj + mid + chi + right;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
        scn.close();
    }
}
