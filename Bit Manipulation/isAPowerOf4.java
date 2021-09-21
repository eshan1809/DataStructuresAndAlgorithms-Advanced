/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.
*/

import java.util.*;

public class isAPowerOf4 {
    public static boolean isPowerOfFour(int n) {
        if (n == Integer.MIN_VALUE || n == 0)
            return false;
        int rsb = (n & -n);
        if (n == rsb) {
            int count = 0;
            while (n > 1) {
                n = (n >> 1);
                count++;
            }
            return ((count & 1) == 0);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(isPowerOfFour(n));
    }
}
