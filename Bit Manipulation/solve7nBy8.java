/*
1. You are given a number n.
2. You have to calculate the value of 7n/8 without using division and multiplication.
*/

import java.util.*;

public class solve7nBy8 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        // write your code here

        // (7 * n) / 8 == (8*n - n) / 8
        int num = (n << 3); // multiplied n by 8
        num -= n; // 8*n - n
        num = (num >> 3); // (8*n - n) / 8 = 7*n / 8
        System.out.println(num);
    }

}