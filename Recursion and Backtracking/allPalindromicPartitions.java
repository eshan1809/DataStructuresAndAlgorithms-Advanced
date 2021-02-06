/*
1. You are given a string of length n.
2. You have to partition the given string in such a way that every partition is a palindrome.
*/

import java.util.*;

public class allPalindromicPartitions {

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String ps = str.substring(0, i + 1);
            String rems = str.substring(i + 1);
            if (isPalindrome(ps)) {
                solution(rems, asf + "(" + ps + ") ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
        scn.close();
    }

}