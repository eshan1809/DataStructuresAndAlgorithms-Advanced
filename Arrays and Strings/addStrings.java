/*
1. Given two non-negative integers, num1 and num2 represented as string.
2. Return the sum of num1 and num2 as a string.
3. You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
4. You must also not convert the inputs to integers directly.
*/

import java.util.*;

public class addStrings {

    public static String solution(String num1, String num2) {
        // write your code here
        String str = "";
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int x = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            i--;
            j--;
        }
        while (i >= 0) {
            int x = (num1.charAt(i) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            i--;
        }
        while (j >= 0) {
            int x = (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            j--;
        }
        if (carry > 0)
            str = carry + str;
        return str;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String n1 = scn.nextLine();
        String n2 = scn.nextLine();
        scn.close();
        String res = solution(n1, n2);
        System.out.println(res);
    }
}