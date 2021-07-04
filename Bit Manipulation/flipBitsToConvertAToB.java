/*
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
*/

import java.util.*;

public class flipBitsToConvertAToB {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        scn.close();
        // write your code here
        int count = 0, xor = a ^ b;
        while (xor > 0) {
            int rmsb = (xor & -xor);
            xor -= rmsb;
            count++;
        }
        System.out.println(count);
    }

}